package com.cn.zy.nio.com.cn.zy.channel.ex.base;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: zhangyi
 * @date: 2018/11/30 15:38
 * @description:
 */
public class InitList {

    private List<Integer> dataList = new ArrayList<>();

    private List<Integer> data1List = new ArrayList<>();
    private Integer count;
    public InitList(Integer count){
        this.count = count;
        while(count-- >0){
            int floor = (int)Math.floor(Math.random() * 1000);
            dataList.add(floor);
            data1List.add(floor);
        }
    }
    public List<Integer> getDataList() {
        return dataList;
    }

    public List<Integer> getData1List() {
        return data1List;
    }
}
