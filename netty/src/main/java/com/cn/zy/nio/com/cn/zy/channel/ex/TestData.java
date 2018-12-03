package com.cn.zy.nio.com.cn.zy.channel.ex;

import org.junit.Test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

/**
 * @author: zhangyi
 * @date: 2018/11/30 14:42
 * @description:
 */
public class TestData {

    public static final String FILE_SIZE = "F:\\JAVA-IDEA\\JavaProject\\netty\\src\\main\\resources\\data.txt";
    @Test
    public void addData() throws Exception{
        BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File(FILE_SIZE))));
        int count = 1000;

        while(count-- >0){
            int floor = (int)Math.floor(Math.random() * count);
            System.out.println(floor);
        }
    }
}
