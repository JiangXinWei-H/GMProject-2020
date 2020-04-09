package com.zhongruan.dao;

import com.zhongruan.bean.Role;

import java.util.List;

/**
 *  数据库交互层
 */
public interface IRoleDao {

    // 查询全部角色
    List<Role> findAllRole();

    // 角色新增
    void addRole(Role role);

    // 角色删除
    void delRoleById(int rid);


    // 根据用户ID去查询role角色
    List<Role> findRoleByUserId(int uid);



}
