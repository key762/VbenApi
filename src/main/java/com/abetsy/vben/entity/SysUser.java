package com.abetsy.vben.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("vben_sys_user")
public class SysUser extends BaseEntity {

    /**
     * 用户UID
     */
    @TableId(type = IdType.AUTO)
    private Long uid;

    /**
     * 用户名
     */
    private String username;

    /**
     * 用户密码
     */
    private String password;

    /**
     * 用户密码加密盐
     */
    private String salt;

    /**
     * 用户电话
     */
    private String phone;


    /**
     * 用户邮箱
     */
    private String email;

    /**
     * 用户头像
     */
    private String avatar;

    /**
     * 用户昵称
     */
    private String nickname;

    /**
     * 用户真名
     */
    private String realName;

    /**
     * 用户是否启用
     */
    private boolean enabled;

    /**
     * 用户主页
     */
    private String homePath;

    /**
     * 用户账户是否未过期
     */
    private boolean accountNonExpired;

    /**
     * 用户账户是否凭据未过期
     */
    private boolean credentialsNonExpired;

    /**
     * 用户账户是否账户未锁定
     */
    private boolean accountNonLocked;

    /**
     * 用户部门
     */
    private Integer deptId;

}
