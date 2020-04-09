package com.zhongruan.dao;

import com.zhongruan.bean.UserInfo;

import java.util.List;

public interface IUserInfoDao {
    // 登陆
    UserInfo doLogin(String username);

    // 全部查询
    List<UserInfo> findAll();

    // 增加操作
    void addUser(UserInfo userInfo);

    // 删除， 根据主键ID
    void delUserById(int id);

    // 修改前的查询
    UserInfo updSelUserInfoById(int id);

    // 修改
    void updUserInfo(UserInfo userInfo);
}
