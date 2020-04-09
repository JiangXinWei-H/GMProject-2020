package com.zhongruan.service.impl;

import com.github.pagehelper.PageHelper;
import com.zhongruan.bean.Role;
import com.zhongruan.dao.IRoleDao;
import com.zhongruan.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RoleServiceImpl implements IRoleService {

    @Autowired
    private IRoleDao roleDao;

    @Override
    public List<Role> findAllRole(Integer page, Integer size) {

        PageHelper.startPage(page,size);

        return roleDao.findAllRole();
    }

    @Override
    public void addRole(Role role) {
        roleDao.addRole(role);
    }

    @Override
    public void delRoleById(int rid) {
        roleDao.delRoleById(rid);
    }
}
