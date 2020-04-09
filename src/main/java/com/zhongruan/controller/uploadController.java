package com.zhongruan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
@RequestMapping("/uploadController")
public class uploadController {

    private static final String UPLOAD_PATH = "F:/upload";



    // 如何去实现参数的封装 ： 上传的时候，如何给出判断或者验证
    // 需要：  CommonsMultipartResolver ， 配置SpringMVC容器
    @RequestMapping("/upload.do")
    public ModelAndView upload(@RequestParam("myPic") MultipartFile myPic) throws IOException {

        // 1. 文件在服务器上的存储
        // 先生成新的文件名
        UUID rid = UUID.randomUUID();
        long uid = rid.getLeastSignificantBits();

        // 取出后缀名， 进行字符串的拼接
        String filename = myPic.getOriginalFilename();
        // http://b-ssl.duitang.com/uploads/item/201807/11/20180711023132_jlxnx.jpeg
        String suffix = filename.substring(filename.lastIndexOf('.'));
        File file = new File(UPLOAD_PATH + "/" + uid + suffix);

        // throws 和 try .. catch 有什么区别
        myPic.transferTo(file);


        // 2. 文件地址的回显
        ModelAndView mv = new ModelAndView();
        mv.setViewName("upload");
        mv.addObject("upload_file_path",file.getName());

        // 3. 给出页面的跳转
        return mv;
    }



}
