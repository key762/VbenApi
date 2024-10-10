package com.abetsy.vben.utils.api;

import lombok.Data;

import java.io.Serializable;

@Data
public class ResultData<T> implements Serializable {

    /**
     * 成功
     */
    final static int SUCCESS = 0;

    /**
     * 失败
     */
    final static int FAIL = -1;

    /**
     * 返回码
     */
    private int code;

    /**
     * 返回信息
     */
    private String msg;

    /**
     * 返回数据
     */
    private T data;

    public ResultData() {
    }

    public ResultData(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ResultData(Integer code, T data) {
        this.code = code;
        this.data = data;
        this.msg = "success";
    }

    public static <T> ResultData<T> success(T data) {
        return new ResultData<>(SUCCESS, data);
    }

    public static <T> ResultData<T> success(String msg) {
        return new ResultData<>(SUCCESS, msg);
    }

    public static <T> ResultData<T> error(String msg) {
        return new ResultData<>(FAIL, msg);
    }

}
