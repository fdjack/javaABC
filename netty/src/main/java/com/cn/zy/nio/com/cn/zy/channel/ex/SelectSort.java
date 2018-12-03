package com.cn.zy.nio.com.cn.zy.channel.ex;

import com.cn.zy.nio.com.cn.zy.channel.ex.base.InitList;

import java.util.List;

/**
 * @author: zhangyi
 * @date: 2018/11/30 15:41
 * @description:
 */
public class SelectSort extends InitList {
    public SelectSort(Integer count) {
        super(count);
    }

    /**
     * 首先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置，
     * 然后，再从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾。
     * 以此类推，直到所有元素均排序完毕。
     *
     * @param args
     */
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        SelectSort selectSort = new SelectSort(100);
        List<Integer> data1List = selectSort.getData1List();
        List<Integer> dataList = selectSort.getDataList();
        System.out.println();
        int min = 0;
        for (int i = 0; i < data1List.size(); i++) {
            //假设第一个下标元素最小
            min = i;
            for(int j = i+1; j < data1List.size();j++){
                if(data1List.get(j) < data1List.get(min)){
                    min = j;
                }
            }
            int temp = data1List.get(i);
            data1List.set(i,data1List.get(min));
            data1List.set(min,temp);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("时间："+(endTime-startTime));
        data1List.stream().forEach(e -> System.out.print(e + " "));
    }
}
