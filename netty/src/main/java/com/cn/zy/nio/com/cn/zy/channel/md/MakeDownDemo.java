package com.cn.zy.nio.com.cn.zy.channel.md;

import org.junit.Test;
import org.markdown4j.Markdown4jProcessor;

import java.io.*;

/**
 * @author: zhangyi
 * @date: 2018/11/21 22:57
 * @description:
 */
public class MakeDownDemo {

    @Test
    public void md(){
        InputStream resourceAsStream = null;
        BufferedWriter bufferedWriter = null;
        try {
            resourceAsStream =
                    this.getClass().getClassLoader().getResourceAsStream("README.md");
            String process = new Markdown4jProcessor().process(resourceAsStream);
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File("F:\\JAVA-IDEA\\JavaProject\\netty\\src\\main\\resources\\1.html"))));
            bufferedWriter.write(process);
            bufferedWriter.flush();
        }catch (IOException e){

        }finally {
            try {
                resourceAsStream.close();
                bufferedWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
