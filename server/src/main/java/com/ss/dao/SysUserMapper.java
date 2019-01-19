package com.ss.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ss.entity.SysUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

//@Mapper
public interface SysUserMapper extends BaseMapper<SysUser> {

    List<SysUser> selectUserIncludeRoles(Page page, @Param("nick")String nick);

}
