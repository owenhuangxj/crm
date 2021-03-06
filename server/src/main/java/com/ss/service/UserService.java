package com.ss.service;

import com.ss.entity.User;

public interface UserService {
/*登陆判断*/
    User selectUser(String userName, String password);
/*注册*/
    User getEmail(String email);
    User getUserName(String userName);
    int insertUser(String email, String userName, String password);

    Integer selectUserId(String createDate);
}
