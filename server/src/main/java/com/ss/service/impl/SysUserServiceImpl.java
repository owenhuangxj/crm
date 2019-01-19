package com.ss.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ss.dao.SysUserMapper;
import com.ss.entity.SysUser;
import com.ss.service.SysUserService;
import org.springframework.stereotype.Service;

@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {

    @Override
    public Page<SysUser> queryUserIncludeRoles(Page page, String nick) {
        return page.setRecords(baseMapper.selectUserIncludeRoles(page,nick));
    }

}
