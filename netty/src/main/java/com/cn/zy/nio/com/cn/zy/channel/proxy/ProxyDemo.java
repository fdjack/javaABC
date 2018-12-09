package com.cn.zy.nio.com.cn.zy.channel.proxy;

import com.cn.zy.nio.com.cn.zy.channel.proxy.proxy.MethodClass;
import com.cn.zy.nio.com.cn.zy.channel.proxy.proxy.ProxyClass;
import com.cn.zy.nio.com.cn.zy.channel.proxy.service.AimsClassService;
import com.cn.zy.nio.com.cn.zy.channel.proxy.service.impl.AimsClassImpl;
import org.junit.Test;

/**
 *  java静态代理
 *
 * @author: zhangyi
 * @date: 2018/12/3 21:31
 * @description:
 */
public class ProxyDemo {

    @Test
    public void proxy(){
        AimsClassImpl aimsClassService = new AimsClassImpl();
        ProxyClass proxyClass = new ProxyClass(aimsClassService);
        Object bind = proxyClass.bind();
        AimsClassService aProxy = (AimsClassService)bind;
//        aProxy.voidReturn();
        aProxy.nonEmptyReturn("");
    }

    @Test
    public void method(){
        AimsClassImpl aimsClass = new AimsClassImpl();
        MethodClass methodClass = new MethodClass(aimsClass);
        AimsClassImpl object = (AimsClassImpl)methodClass.getObject();
        object.voidReturn();
        String hi = object.nonEmptyReturn("");
        System.out.println(hi);
    }
}
