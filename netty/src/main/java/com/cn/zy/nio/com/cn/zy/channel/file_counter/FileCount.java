package com.cn.zy.nio.com.cn.zy.channel.file_counter;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 统计项目代码行
 *
 * @author: zhangyi
 * @date: 2018/12/3 16:36
 * @description:
 */
public class FileCount {

    public static final String srcCodePath = "F:\\B-Test\\yssmt\\";

    public static final String aimsCodePath = "F:\\B-Test\\test.txt";

    /**
     *  每行字符最小值
     */
    public static final Integer LINE_MIN = 5;

    public List<File> lists = new ArrayList<>();

    public Integer fileCount = 0;

    @Test
    public void getFileCount() throws IOException{
        File fileList = new File(srcCodePath);
        List<File> files = dgFile(fileList);
        for(File f : files){
            StringBuilder fileName = new StringBuilder("文件名："+f.getName() + "\r\n \r\n");
            //文件内容
            StringBuilder fileBody = getFileBody(f);
            //写操作
            writeFileBody(fileName.append(fileBody));
        }
        System.out.println("文件个数： "+fileCount);
    }

    private List<File> dgFile(File file){
        for(File e: file.listFiles()){
            if(e.isDirectory()){
                dgFile(e);
            }else {
                if(!StringUtils.contains(file.getAbsolutePath(),".git")){
                    lists.add(e);
                }
            }
        }
        return lists;
    }

    /**
     * 获取文件内容
     *
     * @param filePath
     * @return
     */
    private StringBuilder getFileBody(File filePath) throws IOException{
        StringBuilder stringBuilder = new StringBuilder();
        BufferedReader bfr =
                new BufferedReader(new InputStreamReader(new FileInputStream(filePath)));
        String str = "";
        while((str = bfr.readLine()) != null){
                str = new String(str.getBytes("GBK"), "UTF8");
                stringBuilder.append(str + "\r\n");
                fileCount += str.toCharArray().length;
        }
        return stringBuilder;
    }

    /**
     * 写文件内容
     *
     * @param body
     */
    private void writeFileBody(StringBuilder body) throws IOException {
        File file = new File(aimsCodePath);
        BufferedWriter bfw =
                new BufferedWriter(
                        new OutputStreamWriter(
                                new FileOutputStream(file,true)));
        bfw.write(body.toString()+"\r\n");
        bfw.close();
    }
}
