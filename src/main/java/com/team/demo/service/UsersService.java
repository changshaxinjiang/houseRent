package com.team.demo.service;

import com.team.demo.entity.Users;

public interface UsersService {

    //注册用户
    public int regUser(Users user);

    //用户登录
    public Users loginUser(Users user);
}
