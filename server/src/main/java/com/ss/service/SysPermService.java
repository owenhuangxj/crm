package com.ss.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ss.entity.SysPerm;
import com.ss.vo.AuthVo;

import java.util.List;
import java.util.Set;

public interface SysPermService extends IService<SysPerm> {

    Set<AuthVo> getPermsByUserId(String userId);

    List<SysPerm> getPermsByRoleId(String roleId);

    void saveOrUpdate(List<SysPerm> perms);



}
