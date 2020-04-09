package com.zhongruan.controller;

import com.github.pagehelper.PageInfo;
import com.zhongruan.bean.UserInfo;
import com.zhongruan.service.IUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("user")
public class UserInfoController {

    @Autowired
    private IUserInfoService userInfoService;

//    @RequestMapping("doLogin.do")
//    public String doLogin(String username, String password, HttpSession session){
//        UserInfo userInfo = userInfoService.doLogin(username);
//        if (userInfo !=null ){
//            if(userInfo.getPassword().equals(password)){
//                System.out.println("登陆成功！");
//                session.setAttribute("userInfo",userInfo);
//                return "main";
//            }else {
//                System.out.println("密码错误，登陆失败！");
//                session.setAttribute("message","密码错误，请重新登陆！");
//                return "../login";
//            }
//        }else {
//            System.out.println("用户不存在，请检查重新登陆！");
//            session.setAttribute("message","用户不存在，请重新登陆！");
//            return "../login";
//        }
//    }


    //  全部查询
    // 所有需要返回数据到页面显示的全部都需要封装到ModelAndVIew中
    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(defaultValue = "1") Integer page,
                                @RequestParam(defaultValue = "5") Integer size){
        // 调用service中的方法，得到查询结果
        List<UserInfo> userInfoList = userInfoService.findAll(page,size);

        // 把得到的数据存放到 PageInfo中
        PageInfo pageInfo = new PageInfo(userInfoList);

        ModelAndView mv = new ModelAndView();
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("user-list");
        return mv;
    }

    // 增加
    @RequestMapping("/addUser.do")
    public String addUser(UserInfo userInfo){
        // 调用 service，得到结果。
        userInfoService.addUser(userInfo);
        // 增加成功，返回重新查询
        return "redirect:findAll.do";
    }

    //  删除
    @RequestMapping("/delUser.do")
    public String delUserById(int id){
        userInfoService.delUserById(id);
        System.out.println("删除成功");
        return "redirect:findAll.do";
    }

    // 修改前的查询
    // JDBC 和 Mybatis 有什么区别
    @RequestMapping("/updSelUserById.do")
    public ModelAndView updSelUserInfoById(int id){
        UserInfo userInfo = userInfoService.updSelUserInfoById(id);

        ModelAndView mv = new ModelAndView();
        mv.addObject("userInfo",userInfo);
        mv.setViewName("user-update");

        return mv;
    }

    // 修改
    @RequestMapping("/updUserInfo.do")
    public String updUserInfo(UserInfo userInfo){

        userInfoService.updUserInfo(userInfo);
        System.out.println("修改成功");

        return "redirect:findAll.do";
    }



}
