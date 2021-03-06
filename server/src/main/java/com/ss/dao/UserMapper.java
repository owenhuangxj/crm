package com.ss.dao;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ss.entity.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper extends BaseMapper<User> {

    /**
     * 查询用户姓名
     * @param userId 用户id
     * @return 用户姓名
     */
    User getUserNameByUserId(@Param("userId") int userId);

    Integer getCount(@Param("create_date") String createDate);

}
