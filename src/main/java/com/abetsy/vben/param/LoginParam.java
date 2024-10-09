package com.abetsy.vben.param;

import lombok.Data;

import java.io.Serializable;


@Data
public class LoginParam implements Serializable {

    /**
     * 用户账号
     */
    private String username;

    /**
     * 用户密码
     */
    private String password;
}