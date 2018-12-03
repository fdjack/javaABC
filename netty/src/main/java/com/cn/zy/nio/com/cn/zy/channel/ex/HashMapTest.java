package com.cn.zy.nio.com.cn.zy.channel.ex;

import org.junit.Test;

import java.util.HashMap;
import java.util.UUID;

/**
 * @author: zhangyi
 * @date: 2018/12/1 20:42
 * @description:
 */
public class HashMapTest {
    final HashMap<String, String> map = new HashMap<>();

    @Test
    public void test(){
        for (int i = 0; i < 2000; i++) {
            new Thread(() -> {
                    map.put(UUID.randomUUID().toString(), "");
            }).start();
        }
    }
}
