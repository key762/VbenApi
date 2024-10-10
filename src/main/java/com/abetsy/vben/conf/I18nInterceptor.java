package com.abetsy.vben.conf;

import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class I18nInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        List<Locale> locales = Arrays.asList(Locale.SIMPLIFIED_CHINESE, Locale.US);
        Locale locale = request.getLocale();
        if (locales.contains(locale)) {
            LocaleContextHolder.setLocale(locale);
        } else {
            LocaleContextHolder.setLocale(Locale.SIMPLIFIED_CHINESE);
        }
        return true;
    }
}
