package com.abetsy.vben.service.impl;

import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.digest.BCrypt;
import com.abetsy.vben.dao.SysUserMapper;
import com.abetsy.vben.entity.SysUser;
import com.abetsy.vben.param.LoginParam;
import com.abetsy.vben.service.SysUserService;
import com.abetsy.vben.utils.i18n.VbenException;
import com.abetsy.vben.vo.InfoVo;
import com.abetsy.vben.vo.LoginVo;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class SysUserServiceImpl implements SysUserService {

    @Resource
    private SysUserMapper sysUserMapper;

    @Override
    public LoginVo login(LoginParam param) {
        QueryWrapper<SysUser> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.eq("username", param.getUsername());
        SysUser selectOne = sysUserMapper.selectOne(userQueryWrapper);
        // 密码判断
        if (selectOne == null) {
            VbenException.locale("account.no.found", param.getUsername());
        }
        // 加密密码
//        String encryptedPassword = BCrypt.hashpw("myPassword", BCrypt.gensalt());
        if (!BCrypt.checkpw(selectOne.getSalt()+param.getPassword(), selectOne.getPassword())) {
            VbenException.locale("account.password.error");
        }
        StpUtil.login(selectOne.getUid());
        LoginVo loginVo = new LoginVo();
        loginVo.setAccessToken(StpUtil.getTokenValue());
        loginVo.setId(selectOne.getUid());
        loginVo.setPassword(param.getPassword());
        loginVo.setRoles(Collections.singletonList("super"));
        loginVo.setRealName(StrUtil.isEmpty(selectOne.getRealName()) ? selectOne.getUsername() : selectOne.getRealName());
        loginVo.setUsername(selectOne.getUsername());
        return loginVo;
    }

    @Override
    public InfoVo info() {
        QueryWrapper<SysUser> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.eq("uid", Integer.parseInt(StpUtil.getLoginId().toString()));
        SysUser selectOne = sysUserMapper.selectOne(userQueryWrapper);
        StpUtil.login(selectOne.getUid());
        InfoVo infoVo = new InfoVo();
        infoVo.setId(selectOne.getUid());
        infoVo.setRoles(Collections.singletonList("super"));
        infoVo.setRealName(StrUtil.isEmpty(selectOne.getRealName()) ? selectOne.getUsername() : selectOne.getRealName());
        infoVo.setUsername(selectOne.getUsername());
        return infoVo;
    }

    @Override
    public List<String> codes() {
        return Arrays.asList("AC_100100", "AC_100110", "AC_100120", "AC_100010");
    }

}
