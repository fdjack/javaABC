package com.zy;

import com.zy.utils.QRCodeUtil;
import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Arrays;
import java.util.UUID;

/**
 * @author: zhangyi
 * @date: 2018/8/20 08:12
 * @description:
 */
public class ZxingDemo {

    @Test
    public void fun() throws Exception{
        String[] urls = new String[]{
                "http://118.31.228.186/apk/yishusmt.apk",
                "https://yishusmt.oss-cn-hangzhou.aliyuncs.com/yishusmt_mob/apk/yishusmt.apk"
        };
        //生成后的图片路径
        String dir = "E:\\smt-api\\erweima\\";
        //二维码自带logo图片路径
        String logoImgPath = "E:\\smt-api\\erweima\\icon.png";
        File file = new File(dir);
        Arrays.stream(urls).forEach(url -> {
            try {
                QRCodeUtil.encode(url, logoImgPath, new FileOutputStream(file+"\\"+UUID.randomUUID()+".jpg"), true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

}
