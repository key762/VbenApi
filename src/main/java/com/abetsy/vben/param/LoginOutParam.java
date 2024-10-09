package com.abetsy.vben.param;

import lombok.Data;

import java.io.Serializable;


@Data
public class LoginOutParam implements Serializable {

    /**
     * 登出凭证
     */
    private boolean withCredentials;

}