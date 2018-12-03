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
     该算法是采用分治法（Divide and Conquer）的一个非常典型的应用。将已有序的子序列合并，
     得到完全有序的序列；即先使每个子序列有序，再使子序列段间有序。
     若将两个有序表合并成一个有序表，称为2-路归并。

     1、把长度为n的输入序列分成两个长度为n/2的子序列；
     2、对这两个子序列分别采用归并排序；
     3、将两个排序好的子序列合并成一个最终的排序序列。
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
        System.out.println("时间："+(endTime-startTime));
        dataList.stream().forEach(e -> System.out.print(e + " "));
    }
}
