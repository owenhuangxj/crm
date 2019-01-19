package com.ss.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
//@Data
@TableName("sys_role_perm")
//@NoArgsConstructor
//@AllArgsConstructor
public class SysRolePerm implements Serializable {
    @TableField("role_id")
    private String roleId;
    @TableField("perm_val")
    private String permVal;
    @TableField("perm_type")
    private Integer permType;

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getPermVal() {
        return permVal;
    }

    public void setPermVal(String permVal) {
        this.permVal = permVal;
    }

    public Integer getPermType() {
        return permType;
    }

    public void setPermType(Integer permType) {
        this.permType = permType;
    }

    public SysRolePerm() {
    }

    public SysRolePerm(String roleId, String permVal, Integer permType) {
        this.roleId = roleId;
        this.permVal = permVal;
        this.permType = permType;
    }
}
