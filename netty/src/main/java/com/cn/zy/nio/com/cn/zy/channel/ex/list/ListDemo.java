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
        System.out.println("�����ȣ�"+listUtils.getLenght());
        listUtils.insert(2,1000);
        listUtils.traverse();

        boolean remove = listUtils.remove(2);

        System.out.println("�Ƴ�״̬��"+remove);
        listUtils.traverse();
        System.out.println("�����ȣ�"+listUtils.getLenght());

    }

}
