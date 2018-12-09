package com.cn.zy.nio.com.cn.zy.channel.ex.base;

import java.util.Comparator;

/**
 * @author: zhangyi
 * @date: 2018/11/30 15:13
 * @description:
 */
public interface SortBase {

    /**
     * 比较接口
     *
     * @param unsorted
     * @param <T>
     * @return
     */
    <T extends Comparator<T>> T[] sort(T[] unsorted);
}
