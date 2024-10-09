package com.abetsy.vben.api;

import cn.dev33.satoken.stp.StpUtil;
import com.abetsy.vben.param.LoginParam;
import com.abetsy.vben.service.SysUserService;
import com.abetsy.vben.utils.api.ResultData;
import com.abetsy.vben.vo.LoginVo;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 登录与注销
 */
@RestController
@RequestMapping("/auth")
public class LoginController {

    @Resource
    private SysUserService userService;

    /**
     * 登录
     */
    @PostMapping("/login")
    public ResultData<LoginVo> login(@RequestBody @Validated LoginParam param) {
        return ResultData.success(userService.login(param));
    }

    /**
     * 登出
     */
    @PostMapping("/logout")
    public ResultData<LoginVo> logout(@RequestBody @Validated LoginParam param) {
        StpUtil.logout();
        return ResultData.success("");
    }

    /**
     * 登出
     */
    @GetMapping("/codes")
    public ResultData<List<String>> codes() {
        return ResultData.success(userService.codes());
    }

}
