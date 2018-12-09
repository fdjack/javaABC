package com.cn.zy.nio.com.cn.zy.channel.io;

import org.junit.Test;

import java.io.*;

/**
 * @author: zhangyi
 * @date: 2018/12/6 11:26
 * @description:
 */
public class PrintStreamDemo {

    @Test
    public void printf() throws FileNotFoundException, UnsupportedEncodingException {
        File file = new File("F:\\JAVA-IDEA\\JavaProject\\netty\\src\\main\\resources\\data.txt");
        PrintStream printStream = new PrintStream(new FileOutputStream(file),true,"UTF-8");
        printStream.printf(" 你好世界手机");
        printStream.println("ni ");
    }
}
