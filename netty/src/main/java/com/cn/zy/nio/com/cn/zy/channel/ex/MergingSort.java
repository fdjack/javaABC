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
        System.out.println("ʱtime: "+(endTime-startTime));
        dataList.stream().forEach(e -> System.out.print(e + " "));
    }
}
