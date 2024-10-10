package com.abetsy.vben.conf;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class I18nConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        I18nInterceptor i18nInterceptor = new I18nInterceptor();
        InterceptorRegistration registration = registry.addInterceptor(i18nInterceptor);
        registration.addPathPatterns("/**");
    }
}
