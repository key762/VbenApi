package com.abetsy.vben.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class LoginVo implements Serializable {

    /**
     * 认证Token
     */
    private String accessToken;

    /**
     * 用户ID
     */
    private Long id;

    /**
     * 用户密码
     */
    private String password;

    /**
     * 用户真名
     */
    private String realName;

    /**
     * 用户角色
     */
    private List<String> roles;

    /**
     * 用户名称
     */
    private String username;

}