package com.cn.zy.nio.com.cn.zy.channel.delay.timer;

import org.junit.Test;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @author: zhangyi
 * @date: 2018/12/4 21:51
 * @description:
 */
public class TimerDemo {

    @Test
    public void delay(){
        boolean[] flag = new boolean[]{true};
            new Timer().schedule(new TimerTask() {
                @Override
                public void run() {
                    System.out.println("END");
                    flag[0] = false;
                }
            }, 10);
        while(flag[0]){
            System.out.println(new Date(System.currentTimeMillis()));
        }
    }
    @Test
    public void timer(){
        Calendar instance = Calendar.getInstance();
        instance.set(Calendar.HOUR,10);
        instance.set(Calendar.MINUTE,41);
        instance.set(Calendar.SECOND,0);
        Date time = instance.getTime();

        new Timer().scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
//                System.out.println("5秒延迟后，以1秒为频率执行");
                System.out.println("在当前时间片过后，一1秒频率执行");
            }
//        },5000,1000);
            //在当前时间片过后，一1秒频率执行
        },time,1000);
       while(true){}
    }

    @Test
    public void timer1(){
        Calendar instance = Calendar.getInstance();
        instance.set(Calendar.SECOND,3);
        //等待1秒执行，每个2秒执行一次
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println(new Date(System.currentTimeMillis()));
            }
        },1000,2000);
        while(true){}
    }
}
