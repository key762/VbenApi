package com.abetsy.vben.api;

import com.abetsy.vben.service.SysUserService;
import com.abetsy.vben.utils.api.ResultData;
import com.abetsy.vben.vo.InfoVo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private SysUserService userService;

    @GetMapping("/info")
    public ResultData<InfoVo> login() {
        return ResultData.success(userService.info());
    }

}
