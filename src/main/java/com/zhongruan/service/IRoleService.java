package com.zhongruan.service;

import com.zhongruan.bean.Role;

import java.util.List;

/**
 *  业务逻辑层
 */
public interface IRoleService {


    // 分页查询
    List<Role> findAllRole(Integer page, Integer size);

    void addRole(Role role);

    void delRoleById(int id);
}
