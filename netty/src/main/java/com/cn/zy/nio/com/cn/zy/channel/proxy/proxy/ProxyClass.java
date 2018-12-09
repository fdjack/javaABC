package com.cn.zy.nio.com.cn.zy.channel.proxy.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author: zhangyi
 * @date: 2018/12/3 21:43
 * @description:
 */
public class ProxyClass implements InvocationHandler {
    private Object target;

    public ProxyClass(Object target) {
        this.target = target;
    }

    /**
     * 绑定对象
     *
     * @return
     */
    public Object bind(){
        return Proxy.newProxyInstance(
                getTarget().getClass().getClassLoader(),
                target.getClass().getInterfaces(),this);
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object invoke = null;
        //before...
        System.out.println("方法预处理方法");

        invoke = method.invoke(target, args);

        for(Object a : args){
            if(a instanceof String){
                System.out.println(a);
            }
        }
        //after...
        System.out.println("方法后续操作处理");
        return invoke;
    }

    public Object getTarget() {
        return target;
    }
}
