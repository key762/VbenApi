package com.abetsy.vben.service;

import com.abetsy.vben.param.LoginParam;
import com.abetsy.vben.vo.InfoVo;
import com.abetsy.vben.vo.LoginVo;

import java.util.List;

public interface SysUserService {

    /**
     * 登录
     */
    LoginVo login(LoginParam param);

    /**
     * 详情
     */
    InfoVo info();

    List<String> codes();
}
