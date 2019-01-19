package com.ss.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ss.entity.SysRole;
import com.ss.vo.AuthVo;

import java.util.List;
import java.util.Set;

public interface SysRoleService extends IService<SysRole> {

    Set<AuthVo> getRolesByUserId(String userId);

    List<String> getRoleIdsByUserId(String userId);

    boolean checkRidsContainRval(List<String> rids, String rval);

    boolean checkUidContainRval(String uid, String rval);

}
