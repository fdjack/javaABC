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
     * ������δ�����������ҵ���С����Ԫ�أ���ŵ��������е���ʼλ�ã�
     * Ȼ���ٴ�ʣ��δ����Ԫ���м���Ѱ����С����Ԫ�أ�Ȼ��ŵ����������е�ĩβ��
     * �Դ����ƣ�ֱ������Ԫ�ؾ�������ϡ�
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
            //�����һ���±�Ԫ����С
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
        System.out.println("ʱ�䣺"+(endTime-startTime));
        data1List.stream().forEach(e -> System.out.print(e + " "));
    }
}
