package com.cn.zy.nio.com.cn.zy.channel.spark;

import com.alibaba.fastjson.JSON;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

/**
 * @author: zhangyi
 * @date: 2018/11/30 16:00
 * @description:
 */
public class Music {

    private String inderss;
//    {"TransCode":"020111","OpenId":"123456789","Body":{"SongListId":"141998290"}}
    @Before
    public void initRUL(){
        inderss = "https://api.hibai.cn/api/index/index";
    }
    @Test
    public void net() throws IOException {
        Body body = new Body("141998290");
        RequestBody requestBody = new RequestBody("020111","123456789",body);
        String json = JSON.toJSONString(requestBody);
        Object o = JSON.toJSON(requestBody);
        System.out.println(o.toString());
        Document con = Jsoup.connect("https://api.hibai.cn/api/index/index")
                .requestBody(o.toString())
                .ignoreContentType(true)
                .header("User-Agent", "Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/69.0.3497.100 Safari/537.36")
                .post();
        System.out.println(con.body());
    }
}
