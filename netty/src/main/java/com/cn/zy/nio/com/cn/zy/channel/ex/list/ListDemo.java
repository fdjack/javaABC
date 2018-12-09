package com.cn.zy.nio.com.cn.zy.channel.ex.list;

import org.junit.Test;

/**
 * @author: zhangyi
 * @date: 2018/11/30 09:41
 * @description:
 */
public class ListDemo {


    @Test
    public void node() {
        ListUtils listUtils = new ListUtils();
        listUtils.add(1);
        listUtils.add(2);
        listUtils.add(5);
        listUtils.add(7);
        listUtils.add(100);
        listUtils.traverse();
        System.out.println("自定义链表长度"+listUtils.getLenght());
        listUtils.insert(2,1000);
        listUtils.traverse();

        boolean remove = listUtils.remove(2);

        System.out.println("移除链表："+remove);
        listUtils.traverse();
        System.out.println("移除后的长度： "+listUtils.getLenght());

    }

}
