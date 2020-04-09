package com.zhongruan.controller;

import com.github.pagehelper.PageInfo;
import com.zhongruan.bean.Role;
import com.zhongruan.service.IRoleService;
import com.zhongruan.service.impl.RoleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/role")  // RestFul webService 代码风格
public class RoleController {

    @Autowired
    private IRoleService roleService;

    // 分页查询
    @RequestMapping("/findAllRole.do")
    public ModelAndView findAllRole(@RequestParam(defaultValue = "1") Integer page,
                                    @RequestParam(defaultValue = "5") Integer size){
        List<Role> roleList = roleService.findAllRole(page, size);
        // 创建出分页中的内置对象，将查询到的list传到对象中
        PageInfo pageInfo = new PageInfo(roleList);

        ModelAndView mv = new ModelAndView();
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("role-list");

        return mv;

    }



    // 增加角色
    @RequestMapping("/addRole.do")
    public String addRole(Role role){
        roleService.addRole(role);
        return "redirect:findAllRole.do";
    }


    // 删除角色
    @RequestMapping("/delRoleById.do")
    public String delRoleById(int rid){
        roleService.delRoleById(rid);
        return "redirect:findAllRole.do";
    }


    public static void main(String[] args) {

    }










}
