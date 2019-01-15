package com.ss.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
public class UpdateRolePermVo implements Serializable{

    private String rid;
    private Integer ptype;
    private List<String> pvals = new ArrayList<>();

    public String getRid() {
        return rid;
    }

    public void setRid(String rid) {
        this.rid = rid;
    }

    public Integer getPtype() {
        return ptype;
    }

    public void setPtype(Integer ptype) {
        this.ptype = ptype;
    }

    public List<String> getPvals() {
        return pvals;
    }

    public void setPvals(List<String> pvals) {
        this.pvals = pvals;
    }
    public UpdateRolePermVo(){

    }

    public UpdateRolePermVo(String rid, Integer ptype, List<String> pvals) {
        this.rid = rid;
        this.ptype = ptype;
        this.pvals = pvals;
    }
}
