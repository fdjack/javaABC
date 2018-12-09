package com.cn.zy.nio.com.cn.zy.channel.redis;

import com.alibaba.fastjson.JSON;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: zhangyi
 * @date: 2018/12/4 13:34
 * @description:
 */
public class RedisDemo {

    private static final Jedis jedis = new Jedis("127.0.0.1",8888);
    @Before
    public void setRedis(){
        TestDemo testDemo = new TestDemo("Jack","sadasdasdas","asdsddsadsa");
        String jsonString = JSON.toJSONString(testDemo);
        jedis.set("test",jsonString);
        List<String> list = new ArrayList<>();
        jedis.del("test");
    }
    @Test
    public void getRedis(){
        String test = jedis.get("test");
        TestDemo testDemo = JSON.parseObject(test, TestDemo.class);
        System.out.println(testDemo.toString());
    }
    @Test
    public void n(){
        //key value key value
//        jedis.mset("a","a1","b","b1");
        //清空缓存
//        String s = jedis.flushDB();
//        System.out.println(s); //OK

        jedis.setnx("a","我是第一个参宿的");
        //本条不插入还是第一个记录
        jedis.setnx("a","呵呵");
    }
    @Test
    public void list(){
        //列表操作
        List<String> lists = jedis.lrange("lists", 0, 2);

        lists.stream().forEach(l -> System.out.println(l));

    }


    @Test
    public void setValue(){
        jedis.zadd("key133",9999.0,"value");
        jedis.zadd("key1",333.0,"value");
        jedis.zadd("key111",11.0,"value");
    }


    @After
    public void after(){
        System.out.println("关闭redis");
        jedis.close();
    }

}
