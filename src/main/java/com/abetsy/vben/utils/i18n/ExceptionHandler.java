package com.abetsy.vben.utils.i18n;

import cn.dev33.satoken.exception.NotLoginException;
import com.abetsy.vben.utils.api.ResultData;
import com.github.yulichang.toolkit.SpringContentUtils;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletResponse;

@CrossOrigin
@RestControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(VbenException.class)
    public Object defaultExceptionHandler(VbenException exception, HttpServletResponse response) {
        response.setStatus(HttpServletResponse.SC_OK);
        MessageSource messageSource = SpringContentUtils.getBean(MessageSource.class);
        String i18nStr = messageSource.getMessage(exception.getMessageKey(), exception.getMessageValue(), exception.getLocale());
        return ResultData.error(i18nStr);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(value = NotLoginException.class)
    public Object handleNotLoginException(NotLoginException e, HttpServletResponse response) {
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        return ResultData.error("UnauthorizedException");
    }

}