package com.cn.zy.nio.com.cn.zy.channel.redis;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @author: zhangyi
 * @date: 2018/12/4 15:03
 * @description:
 */
public class RedisPoolDemo {
    private static final Jedis jedis = new Jedis("127.0.0.1",8888);
    JedisPoolConfig jp = new JedisPoolConfig();
    @Before
    public void initRedis(){
        //config jedis
        jp.setFairness(true);
        jp.setMaxIdle(5);
        jp.setMinIdle(0);
        jp.setMaxTotal(18);
    }

    @Test
    public void operate(){
        JedisPool jedisPool = new JedisPool(jp,"127.0.0.1",8888);
        Jedis jedis = jedisPool.getResource();
//        List<String> lists = jedis.lrange("lists",0,0);
        String lists = jedis.lpop("lists");
        while(lists != null){
            System.out.println(lists);
            lists = jedis.lpop("lists");
        }
//        lists.stream().forEach(l -> System.out.println(l));
    }

    @After
    public void after(){
        System.out.println("redis关闭");
        jedis.close();
    }
}
