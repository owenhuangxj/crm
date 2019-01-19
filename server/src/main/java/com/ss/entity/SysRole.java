package com.ss.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;
import java.util.Date;
@TableName("sys_role")
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
public class SysRole extends Model<SysRole> {

    @TableId(type = IdType.ID_WORKER_STR)
    private String rid;     // 角色id
    private String rname;   // 角色名，用于显示
    private String rdesc;   // 角色描述
    private String rval;    // 角色值，用于权限判断
    private Date created;   // 创建时间
    private Date updated;   // 修改时间

    @Override
    protected Serializable pkVal() {
        return rid;
    }

    public String getRid() {
        return rid;
    }

    public void setRid(String rid) {
        this.rid = rid;
    }

    public String getRname() {
        return rname;
    }

    public void setRname(String rname) {
        this.rname = rname;
    }

    public String getRdesc() {
        return rdesc;
    }

    public void setRdesc(String rdesc) {
        this.rdesc = rdesc;
    }

    public String getRval() {
        return rval;
    }

    public void setRval(String rval) {
        this.rval = rval;
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
    public SysRole(){

    }

    public SysRole(String rid, String rname, String rdesc, String rval, Date created, Date updated) {
        this.rid = rid;
        this.rname = rname;
        this.rdesc = rdesc;
        this.rval = rval;
        this.created = created;
        this.updated = updated;
    }
}
