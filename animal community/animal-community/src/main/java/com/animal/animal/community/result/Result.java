package com.animal.animal.community.result;

public class Result {
    //响应码code属性是一个枚举值（固定）
    private int code;

    public Result(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}