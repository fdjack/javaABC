package com.cn.zy.nio.com.cn.zy.channel.abc;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: zhangyi
 * @date: 2018/12/2 19:55
 * @description:
 */
public class HashMapDemo {

    @Test
    public void hashMap(){
        Map<String,Integer> map = new HashMap<>();
        map.put("a",1);
        map.put("b",2);
        map.put("c",3);
        map.put("d",4);
        map.put("e",5);
        map.put("f",6);
        for(String key : map.keySet()){
            System.out.println(map.get(key));
        }
    }
}
