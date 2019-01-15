package com.ss.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
//@Data
@TableName("sys_user_role")
//@NoArgsConstructor
//@AllArgsConstructor
public class SysUserRole implements Serializable {
    @TableField("user_id")
    private String userId;
    @TableField("role_id")
    private String roleId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public SysUserRole() {
    }

    public SysUserRole(String userId, String roleId) {
        this.userId = userId;
        this.roleId = roleId;
    }
}
