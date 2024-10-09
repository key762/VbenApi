package com.abetsy.vben.utils.api;

import cn.dev33.satoken.exception.NotLoginException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletResponse;

@CrossOrigin
@RestControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
    public Object defaultExceptionHandler(Exception e, HttpServletResponse response) {
        response.setStatus(HttpServletResponse.SC_OK);
        ResultData<Object> data = new ResultData<>();
        data.setCode(100);
        return data;
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(value = NotLoginException.class)
    public Object handleNotLoginException(NotLoginException e, HttpServletResponse response) {
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        ResultData<Object> data = new ResultData<>();
        data.setCode(-1);
        data.setData(null);
        data.setError("Unauthorized Exception");
        data.setMessage("UnauthorizedException");
        return data;
    }

}