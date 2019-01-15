package com.ss.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@TableName("sys_perm")
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
public class SysPerm extends Model<SysPerm> {

    @TableId(type = IdType.INPUT)
    private String pval;    // 权限值，shiro的权限控制表达式
    private String parent;  // 父节点权限值
    private String pname;   // 权限名称
    private Integer ptype;  // 权限类型：1.菜单；2.按钮
    private Boolean leaf;   // 是否叶子节点
    private Date created;   // 创建时间
    private Date updated;   // 修改时间

    @TableField(exist = false)
    private List<SysPerm> children = new ArrayList<>();

    @Override
    protected Serializable pkVal() {
        return pval;
    }

    public String getPval() {
        return pval;
    }

    public String getParent() {
        return parent;
    }

    public String getPname() {
        return pname;
    }

    public Integer getPtype() {
        return ptype;
    }

    public Boolean getLeaf() {
        return leaf;
    }

    public Date getCreated() {
        return created;
    }

    public Date getUpdated() {
        return updated;
    }

    public List<SysPerm> getChildren() {
        return children;
    }

    public void setPval(String pval) {
        this.pval = pval;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public void setPtype(Integer ptype) {
        this.ptype = ptype;
    }

    public void setLeaf(Boolean leaf) {
        this.leaf = leaf;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public void setChildren(List<SysPerm> children) {
        this.children = children;
    }

    public SysPerm() {
    }

    public SysPerm(String pval, String parent, String pname, Integer ptype, Boolean leaf, Date created, Date updated, List<SysPerm> children) {
        this.pval = pval;
        this.parent = parent;
        this.pname = pname;
        this.ptype = ptype;
        this.leaf = leaf;
        this.created = created;
        this.updated = updated;
        this.children = children;
    }
}
