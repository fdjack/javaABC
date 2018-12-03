package com.cn.zy.nio.com.cn.zy.channel.ex;

import com.cn.zy.nio.com.cn.zy.channel.ex.base.InitList;

import java.util.List;

/**
 * @author: zhangyi
 * @date: 2018/11/30 15:41
 * @description:
 */
public class MergingSort extends InitList {
    public MergingSort(Integer count) {
        super(count);
    }

    /**
     ���㷨�ǲ��÷��η���Divide and Conquer����һ���ǳ����͵�Ӧ�á���������������кϲ���
     �õ���ȫ��������У�����ʹÿ��������������ʹ�����жμ�����
     �������������ϲ���һ���������Ϊ2-·�鲢��

     1���ѳ���Ϊn���������зֳ���������Ϊn/2�������У�
     2���������������зֱ���ù鲢����
     3������������õ������кϲ���һ�����յ��������С�
     *
     * @param args
     */
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        MergingSort selectSort = new MergingSort(100);
        List<Integer> data1List = selectSort.getData1List();
        List<Integer> dataList = selectSort.getDataList();
        System.out.println();



        long endTime = System.currentTimeMillis();
        System.out.println("ʱ�䣺"+(endTime-startTime));
        dataList.stream().forEach(e -> System.out.print(e + " "));
    }
}
