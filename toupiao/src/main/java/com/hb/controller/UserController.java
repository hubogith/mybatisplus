package com.hb.controller;

import com.hb.pojo.User;
import com.hb.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
public class UserController {

    @Resource
    private UserService userService;

    //登录
    @RequestMapping("/login")
    @ResponseBody
    public String show(User user, HttpSession session) {
        System.out.println("进来了");
        User show = userService.show(user);
        System.out.println("================="+show);

        String mess = show == null ? "no" : "ok";
        if (show!=null){
            session.setAttribute("user",show);
        }
        return mess;
    }

    //验证用户名方法
    @RequestMapping("/zhuce")
    @ResponseBody
    public String byUserName(String name) {
        User user = userService.byUserName(name);
        String mess = user == null ? "ok" : "on";
        return mess;
    }

    //注册  redirect:/show.html
    @RequestMapping("/register")
    public String addUser(User user) {
        int num = userService.addUser(user);
        String path = num > 0 ? "redirect:/login.html" : "redirect:/regist.html";
        return path;
    }

}
