package com.cn.zy.nio.com.cn.zy.channel.spark;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * @author: zhangyi
 * @date: 2018/11/30 16:14
 * @description:
 */
public class RequestBody {

    @JSONField(name = "TransCode")
    private String TransCode;

    @JSONField(name = "OpenId")
    private String OpenId;

    @JSONField(name = "Body")
    private Body body;

    public RequestBody(String transCode, String openId, Body body) {
        TransCode = transCode;
        OpenId = openId;
        this.body = body;
    }

    public String getTransCode() {
        return TransCode;
    }

    public void setTransCode(String transCode) {
        TransCode = transCode;
    }

    public String getOpenId() {
        return OpenId;
    }

    public void setOpenId(String openId) {
        OpenId = openId;
    }

    public Body getBody() {
        return body;
    }

    public void setBody(Body body) {
        this.body = body;
    }
}

class Body{
    @JSONField(name = "SongListId")
    private String SongListId;

    public Body(String songListId) {
        SongListId = songListId;
    }

    public String getSongListId() {
        return SongListId;
    }

    public void setSongListId(String songListId) {
        SongListId = songListId;
    }
}