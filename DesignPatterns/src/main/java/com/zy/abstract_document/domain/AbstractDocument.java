package com.zy.abstract_document.domain;

import com.zy.abstract_document.Document;

import java.util.function.Function;
import java.util.stream.Stream;

/**
 * @author: zhangyi
 * @date: 2018/8/20 08:32
 * @description:
 */
public class AbstractDocument implements Document {

    @Override
    public void put(String key, Object value) {

    }

    @Override
    public Object get(String key) {
        return null;
    }

    @Override
    public <T> Stream<T> children(String key, Function<String, Object> constructor) {
        return null;
    }
}
