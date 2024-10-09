package com.abetsy.vben.dao;

import com.abetsy.vben.entity.SysUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface SysUserMapper extends BaseMapper<SysUser> {
}
