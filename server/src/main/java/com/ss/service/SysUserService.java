package com.ss.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ss.entity.SysUser;

public interface SysUserService extends IService<SysUser> {

    Page<SysUser> queryUserIncludeRoles(Page page, String nick);

}
