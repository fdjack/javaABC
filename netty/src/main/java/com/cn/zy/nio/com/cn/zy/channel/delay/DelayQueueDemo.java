package com.cn.zy.nio.com.cn.zy.channel.delay;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * @author: zhangyi
 * @date: 2018/12/4 17:12
 * @description:
 */
public class DelayQueueDemo {

    @Test
    public void delay(){
        List<String> list = new ArrayList<>();
        list.add("001");
        list.add("002");
        list.add("003");
        DelayQueue<MyDelay> myDelays = new DelayQueue<>();
        long l = System.currentTimeMillis();

        for(int i = 0;i < list.size();i++){
            myDelays.put(
                    new MyDelay(
                            list.get(i)
                            ,TimeUnit.NANOSECONDS
                            .convert(5,TimeUnit.SECONDS)));
            try {
                myDelays.take().operate();
                long l1 = System.currentTimeMillis();
                System.out.println("After: "+(l1-l)+" Seconds");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class MyDelay implements Delayed {

    private String orderId;

    private Long time;

    public MyDelay(String orderId, Long time) {
        this.orderId = orderId;
        this.time = time;
    }

    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert(
                time-System.nanoTime()
                ,TimeUnit.MILLISECONDS);
    }

    @Override
    public int compareTo(Delayed o) {
        if(o == this){
            return 0;
        }
        MyDelay o1 = (MyDelay) o;
        long l = getDelay(TimeUnit.NANOSECONDS) - o1.getDelay(TimeUnit.NANOSECONDS);
        return l == 0 ? 0 : (l < 0 ? -1 : 1);
    }
    public void operate(){
        System.out.println(orderId+" 编号： 具体操作业务");
    }
}