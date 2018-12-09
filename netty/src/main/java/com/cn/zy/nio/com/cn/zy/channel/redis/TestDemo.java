package com.cn.zy.nio.com.cn.zy.channel.redis;

import lombok.Data;
import lombok.NonNull;

/**
 * @author: zhangyi
 * @date: 2018/12/4 13:45
 * @description:
 */
@Data
public class TestDemo {

    @NonNull
    private String userName;

    @NonNull
    private String password;

    @NonNull
    private String remark;

    public TestDemo(String userName, String password, String remark) {
        this.userName = userName;
        this.password = password;
        this.remark = remark;
    }
}
