package com.zhongruan.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhongruan.bean.Role;
import com.zhongruan.bean.UserInfo;
import com.zhongruan.dao.IRoleDao;
import com.zhongruan.dao.IUserInfoDao;
import com.zhongruan.service.IUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service("userService")
public class UserInfoServiceImpl implements IUserInfoService {

    @Autowired
    private IUserInfoDao userInfoDao;

    @Autowired
    private IRoleDao roleDao;



    @Override
    public UserInfo doLogin(String username) {
        return userInfoDao.doLogin(username);
    }

    // 分页查询
    @Override
    public List<UserInfo> findAll(Integer page, Integer size) {
        PageHelper.startPage(page,size);
        return userInfoDao.findAll();
    }

    @Override
    public void addUser(UserInfo userInfo) {
        userInfoDao.addUser(userInfo);
    }

    @Override
    public void delUserById(int id) {
        userInfoDao.delUserById(id);
    }

    @Override
    public UserInfo updSelUserInfoById(int id) {
        return userInfoDao.updSelUserInfoById(id);
    }

    @Override
    public void updUserInfo(UserInfo userInfo) {
        userInfoDao.updUserInfo(userInfo);
    }







    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 根据姓名查询到当前登录的用户
        UserInfo userInfo = userInfoDao.doLogin(username);
        // 根据当前登录的用户ID，去查询到所属的角色
        List<Role> roleList = roleDao.findRoleByUserId(userInfo.getId());
        userInfo.setRoleList(roleList);

        // 得到想要的信息之后，就要交给Security去处理了
        User user = new User(userInfo.getUsername(),"{noop}"+userInfo.getPassword(),getAuthority(roleList));

        return user;
    }

    private Collection<? extends GrantedAuthority> getAuthority(List<Role> roleList) {
        List<SimpleGrantedAuthority> list = new ArrayList<>();

        for (Role role:roleList) {
            list.add(new SimpleGrantedAuthority("ROLE_"+role.getRname()));
        }
        return list;

    }
}
