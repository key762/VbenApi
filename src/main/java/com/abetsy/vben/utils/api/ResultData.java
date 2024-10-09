package com.abetsy.vben.utils.api;

import lombok.Data;
import java.io.Serializable;

@Data
public class ResultData<T> implements Serializable {

    /**
     * 返回码
     */
    private int code;

    /**
     * 返回信息
     */
    private String message;

    /**
     * 返回信息
     */
    private String msg;

    /**
     * 返回数据
     */
    private T data;

    /**
     * 错误信息
     */
    private T error;

    /**
     * 时间戳
     */
    private Long timeStamp;

    public ResultData() {
    }

    public ResultData(int code, String message, T result) {
        this.code = code;
        this.message = message;
        this.data = result;
        this.timeStamp = System.currentTimeMillis();
    }

    public ResultData(int code, String message) {
        this.code = code;
        this.message = message;
        this.timeStamp = System.currentTimeMillis();
    }

    public ResultData(ResultCode code) {
        this.code = code.getCode();
        this.message = code.getMessage();
        this.timeStamp = System.currentTimeMillis();
    }

    public ResultData(ResultCode code, T result) {
        this.data = result;
        this.code = code.getCode();
        this.message = code.getMessage();
        this.timeStamp = System.currentTimeMillis();
    }

    public ResultData(ResultCode code, String message, T result) {
        this.data = result;
        this.code = code.getCode();
        this.message = message;
        this.timeStamp = System.currentTimeMillis();
    }

    public ResultData(ResultCode code, String message) {
        this.code = code.getCode();
        this.message = message;
        this.timeStamp = System.currentTimeMillis();
    }

    public static <T> ResultData<T> success() {
        return new ResultData<>(ResultCode.SUCCESS);
    }

    public static <T> ResultData<T> success(T data) {
        return new ResultData<>(ResultCode.SUCCESS, data);
    }

    public static <T> ResultData<T> success(String message) {
        return new ResultData<>(ResultCode.SUCCESS, message);
    }

    public static <T> ResultData<T> success(String message, T data) {
        return new ResultData<>(ResultCode.SUCCESS, message, data);
    }

    public static <T> ResultData<T> fail() {
        return new ResultData<>(ResultCode.FAIL);
    }

    public static <T> ResultData<T> fail(T data) {
        return new ResultData<>(ResultCode.FAIL, data);
    }

    public static <T> ResultData<T> fail(String message) {
        return new ResultData<>(ResultCode.FAIL, message);
    }

    public static <T> ResultData<T> fail(String message, T data) {
        return new ResultData<>(ResultCode.FAIL, message, data);
    }

    public static <T> ResultData<T> notFound() {
        return new ResultData<>(ResultCode.NOT_FOUND);
    }

    public static <T> ResultData<T> notFound(T data) {
        return new ResultData<>(ResultCode.NOT_FOUND, data);
    }

    public static <T> ResultData<T> notFound(String message) {
        return new ResultData<>(ResultCode.NOT_FOUND, message);
    }

    public static <T> ResultData<T> notFound(String message, T data) {
        return new ResultData<>(ResultCode.NOT_FOUND, message, data);
    }

    public static <T> ResultData<T> notLogin() {
        return new ResultData<>(ResultCode.NOT_LOGIN);
    }

    public static <T> ResultData<T> notLogin(T data) {
        return new ResultData<>(ResultCode.NOT_LOGIN, data);
    }

    public static <T> ResultData<T> notLogin(String message) {
        return new ResultData<>(ResultCode.NOT_LOGIN, message);
    }

    public static <T> ResultData<T> notLogin(String message, T data) {
        return new ResultData<>(ResultCode.NOT_LOGIN, message, data);
    }

    public static <T> ResultData<T> notAuth() {
        return new ResultData<>(ResultCode.NOT_AUTH);
    }

    public static <T> ResultData<T> notAuth(T data) {
        return new ResultData<>(ResultCode.NOT_AUTH, data);
    }

    public static <T> ResultData<T> notAuth(String message) {
        return new ResultData<>(ResultCode.NOT_AUTH, message);
    }

    public static <T> ResultData<T> notAuth(String message, T data) {
        return new ResultData<>(ResultCode.NOT_AUTH, message, data);
    }

    public static <T> ResultData<T> paramError() {
        return new ResultData<>(ResultCode.PARAM_ERROR);
    }

    public static <T> ResultData<T> paramError(T data) {
        return new ResultData<>(ResultCode.PARAM_ERROR, data);
    }

    public static <T> ResultData<T> paramError(String message) {
        return new ResultData<>(ResultCode.PARAM_ERROR, message);
    }

    public static <T> ResultData<T> systemError() {
        return new ResultData<>(ResultCode.SYSTEM_ERROR);
    }

    public static <T> ResultData<T> systemError(T data) {
        return new ResultData<>(ResultCode.SYSTEM_ERROR, data);
    }

    public static <T> ResultData<T> systemError(String message) {
        return new ResultData<>(ResultCode.SYSTEM_ERROR, message);
    }

    public static <T> ResultData<T> systemError(String message, T data) {
        return new ResultData<>(ResultCode.SYSTEM_ERROR, message, data);
    }

    public static <T> ResultData<T> systemError(int code, String message) {
        return new ResultData<>(code, message);
    }

    public static <T> ResultData<T> systemError(int code, String message, T data) {
        return new ResultData<>(code, message, data);
    }

}
