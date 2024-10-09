package com.abetsy.vben.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class InfoVo implements Serializable {

    /**
     * 用户ID
     */
    private Long id;

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