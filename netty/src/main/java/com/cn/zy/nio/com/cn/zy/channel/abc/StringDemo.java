package com.cn.zy.nio.com.cn.zy.channel.abc;

/**
 *
 * String创建对象在常量池中，只有一个对象
 *
 * @author: zhangyi
 * @date: 2018/12/3 23:08
 * @description:
 */
public class StringDemo {

    public static void main(String[] args) {
        String a = "都是";
        String b = "税收达到";
        String c = a+b;
        System.out.println(a+"--"+b+"--"+c);
    }
}
