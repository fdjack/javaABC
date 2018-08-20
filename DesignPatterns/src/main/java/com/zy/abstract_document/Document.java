package com.zy.abstract_document;

import java.util.function.Function;
import java.util.stream.Stream;

/**
 * @author: zhangyi
 * @date: 2018/8/20 08:27
 * @description:
 */
public interface Document {

    public void put(String key,Object value);

    public Object get(String key);

    <T> Stream<T> children(String key, Function<String,Object> constructor);
}
