package com.cn.zy.nio.com.cn.zy.channel.ex;

import com.cn.zy.nio.com.cn.zy.channel.ex.base.InitList;

import java.util.List;

/**
 * @author: zhangyi
 * @date: 2018/11/30 15:41
 * @description:
 */
public class InsertSort extends InitList {
    public InsertSort(Integer count) {
        super(count);

    }

    /**
     1、从第一个元素开始，该元素可以认为已经被排序；
     2、取出下一个元素，在已经排序的元素序列中从后向前扫描；
     3、如果该元素（已排序）大于新元素，将该元素移到下一位置；
     4、重复步骤3，直到找到已排序的元素小于或者等于新元素的位置；
     5、将新元素插入到该位置后；
     6、重复步骤2~5。
     *
     * @param args
     */
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        InsertSort selectSort = new InsertSort(100);
        List<Integer> data1List = selectSort.getData1List();
        List<Integer> dataList = selectSort.getDataList();
//        List<Integer> dataList = new ArrayList<>();
//        dataList.add(10);
//        dataList.add(100);
//        dataList.add(1);
//        dataList.add(3);
//        dataList.stream().forEach(e -> System.out.print(e+" "));
        for(int index = 0; index < dataList.size(); index++){
            for(int i = index-1; i >= 0; i--){
                if(dataList.get(i) > dataList.get(index)){
                    int temp = dataList.get(index);
                    dataList.set(index,dataList.get(i));
                    dataList.set(i,temp);
                    index = i;
                }
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println("时间："+(endTime-startTime));
        dataList.stream().forEach(e -> System.out.print(e+" "));
    }
}
