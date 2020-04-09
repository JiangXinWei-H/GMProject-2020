package com.zhongruan.service;

import com.zhongruan.bean.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface IUserInfoService extends UserDetailsService {

    UserInfo doLogin(String username);

    // 分页查询
    List<UserInfo> findAll(Integer page, Integer size);

    void addUser(UserInfo userInfo);

    void delUserById(int id);

    UserInfo updSelUserInfoById(int id);

    void updUserInfo(UserInfo userInfo);
}
