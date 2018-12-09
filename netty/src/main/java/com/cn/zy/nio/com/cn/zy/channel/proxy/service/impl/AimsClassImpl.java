package com.cn.zy.nio.com.cn.zy.channel.proxy.service.impl;

import com.cn.zy.nio.com.cn.zy.channel.proxy.service.AimsClassService;

/**
 * 代理对象
 *
 * @author: zhangyi
 * @date: 2018/12/3 21:32
 * @description:
 */
public class AimsClassImpl implements AimsClassService {

    @Override
    public void voidReturn() {
        System.out.println(Thread.currentThread().getName()+"无返回值方法");
    }

    @Override
    public String nonEmptyReturn(String argsString) {
        StringBuilder sb = new StringBuilder(argsString);
        sb.append("--").append(this.getClass().getClassLoader().hashCode());
        sb.append("--").append(Thread.currentThread().getName());
        return sb.toString();
    }
}
