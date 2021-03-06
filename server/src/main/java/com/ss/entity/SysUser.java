package com.ss.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.ss.vo.AuthVo;

import java.io.Serializable;
import java.util.*;
//@Data
@TableName("sys_user")
//@NoArgsConstructor
//@AllArgsConstructor
public class SysUser extends Model<SysUser> {

    @TableId(type = IdType.ID_WORKER_STR)
    private String uid;     // 用户id
    private String uname;   // 登录名，不可改
    private String nick;    // 用户昵称，可改
    private String pwd;     // 已加密的登录密码
    private String salt;    // 加密盐值
    private Boolean lock;   // 是否锁定
    private Date created;   // 创建时间
    private Date updated;   // 修改时间

    @TableField(exist = false)
    private List<SysRole> roleList = new ArrayList<>();    //用户所有角色值，在管理后台显示用户的角色
    @TableField(exist = false)
    private Set<AuthVo> roles = new HashSet<>();    //用户所有角色值，用于shiro做角色权限的判断
    @TableField(exist = false)
    private Set<AuthVo> perms = new HashSet<>();    //用户所有权限值，用于shiro做资源权限的判断

    @Override
    protected Serializable pkVal() {
        return uid;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public Boolean getLock() {
        return lock;
    }

    public void setLock(Boolean lock) {
        this.lock = lock;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public List<SysRole> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<SysRole> roleList) {
        this.roleList = roleList;
    }

    public Set<AuthVo> getRoles() {
        return roles;
    }

    public void setRoles(Set<AuthVo> roles) {
        this.roles = roles;
    }

    public Set<AuthVo> getPerms() {
        return perms;
    }

    public void setPerms(Set<AuthVo> perms) {
        this.perms = perms;
    }

    public SysUser() {
    }

    public SysUser(String uid, String uname, String nick, String pwd, String salt, Boolean lock, Date created, Date updated, List<SysRole> roleList, Set<AuthVo> roles, Set<AuthVo> perms) {
        this.uid = uid;
        this.uname = uname;
        this.nick = nick;
        this.pwd = pwd;
        this.salt = salt;
        this.lock = lock;
        this.created = created;
        this.updated = updated;
        this.roleList = roleList;
        this.roles = roles;
        this.perms = perms;
    }
}
