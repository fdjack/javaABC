package com.cn.zy.nio.com.cn.zy.channel.ex;

import com.cn.zy.nio.com.cn.zy.channel.ex.base.SortBase;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static com.cn.zy.nio.com.cn.zy.channel.ex.utils.SortUtils.swap;

/**
 * @author: zhangyi
 * @date: 2018/11/30 09:27
 * @description:
 */
public class BuboboSort implements SortBase {

    public static List<Integer> dataList = new ArrayList<>();

    public static List<Integer> data1List = new ArrayList<>();
    @Before
    public void initData(){
        int count = 10000;
        while(count-- >0){
            int floor = (int)Math.floor(Math.random() * 100);
            dataList.add(floor);
            data1List.add(floor);
        }
    }

    /**
     * buboo sort
     */
    @Test
    public void test(){
        long l = System.currentTimeMillis();
//        dataList.stream().forEach(e -> System.out.print(e+" "));
        System.out.println("");
        for(int i = 0; i < dataList.size();i++){
            int temp;
            for(int j = i; j < dataList.size();j++){
                if(dataList.get(i) < dataList.get(j)){
                    temp = dataList.get(j);
                    dataList.set(j,dataList.get(i));
                    dataList.set(i,temp);
                }
            }
        }
//        dataList.stream().forEach(e -> System.out.print(e+" > "));
        long l1 = System.currentTimeMillis();
        System.out.println("");
        System.out.println("����ʱ��"+(l1-l));
//
//        long l2 = System.currentTimeMillis();
//        Integer[] objects = (Integer[]) data1List.toArray();
//        Integer[] sort = sort(objects);
//
//        long l3 = System.currentTimeMillis();
//        System.out.println("����ʱ��"+(l3-l2));
    }

    @Override
    public <T extends Comparator<T>> T[] sort(T[] array) {
        int last = array.length;
        boolean swap;
        do{
            swap = false;
            for(int count = 0; count < last - 1; count++){
                T t = array[count];
                T tt = array[count+1];
                if(t.compare(t,tt)< 0){
                    swap = swap(array,count,count+1);
                }
            }
            last--;
        }while(swap);
        return array;
    }
}
