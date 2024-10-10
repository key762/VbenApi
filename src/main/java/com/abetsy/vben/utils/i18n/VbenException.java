package com.abetsy.vben.utils.i18n;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.context.i18n.LocaleContextHolder;

import java.util.Locale;

@Data
@EqualsAndHashCode(callSuper = true)
public class VbenException extends RuntimeException {

    private final String messageKey;
    private final Object[] messageValue;
    private final Locale locale;

    public static void locale(String messageKey) {
        locale(messageKey, new Object[]{});
    }

    public static void locale(String messageKey, Object[] messageValue) {
        Locale locale = LocaleContextHolder.getLocale();
        throw new VbenException(messageKey, messageValue, locale);
    }

}
