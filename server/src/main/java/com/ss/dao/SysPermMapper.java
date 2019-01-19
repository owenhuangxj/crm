package com.ss.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ss.config.MybatisRedisCache;
import com.ss.entity.SysPerm;
import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Param;

import java.util.List;

//@Mapper
@CacheNamespace(eviction = MybatisRedisCache.class,implementation = MybatisRedisCache.class)
public interface SysPermMapper extends BaseMapper<SysPerm> {

    List<SysPerm> getPermsByUserId(@Param("userId") String userId);

    List<SysPerm> getPermsByRoleId(@Param("roleId") String roleId);

    void saveOrUpdate(@Param("perms") List<SysPerm> perms);
}
