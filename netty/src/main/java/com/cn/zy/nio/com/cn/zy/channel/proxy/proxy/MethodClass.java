package com.cn.zy.nio.com.cn.zy.channel.proxy.proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * clib代理
 *
 *
 * @author: zhangyi
 * @date: 2018/12/3 21:55
 * @description:
 */
public class MethodClass  implements MethodInterceptor {

    /**
     * 目标代理对象
     */
    private Object target;

    public MethodClass(Object target) {
        this.target = target;
    }

    public Object getObject(){
        //增强代理，创建cglib类
        Enhancer enhancer = new Enhancer();
        //增强目标对象
        enhancer.setSuperclass(getTarget().getClass());
//        设置回调函数 intercept()拦截方法
        enhancer.setCallback(this);
        //创建对象代理
        Object cgLibObject = enhancer.create();
        return  cgLibObject;
    }
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

        //before...
        System.out.println("CGLIB增强代理 之前");

//        Object invoke = methodProxy.invokeSuper(o, objects);

        Object invoke = method.invoke(target, objects);
        for(Object args: objects){
            if (args instanceof String){
                System.out.println(args);
            }
        }
        //after...
        System.out.println("CGLIB增强代理 之后");
        return invoke;
    }

    public Object getTarget() {
        return target;
    }
}
