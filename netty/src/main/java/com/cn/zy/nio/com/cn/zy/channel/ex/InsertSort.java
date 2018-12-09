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
     *
     * @param args
     */
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        InsertSort selectSort = new InsertSort(100);
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
        System.out.println("Time："+(endTime-startTime));
        dataList.stream().forEach(e -> System.out.print(e+" "));
    }
}
