package com.sz.zhiling.controller;


import com.sz.zhiling.model.ExamUser;
import com.sz.zhiling.service.IUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@RequestMapping("/user")
@Controller
public class UserController {

    @Autowired
    private IUser iUser;

    //开始时跳转到登录界面
    @RequestMapping("/start")
    public String start(){
        return "login";
    }


    //登录操作
    @RequestMapping("/login")
    public String login(ExamUser examUser, Model model, HttpSession session){
        List<ExamUser> list=iUser.selectByUser(examUser);
        for (ExamUser s:list) {
            if(examUser.getUname().equals(s.getUname()) && examUser.getUpwd().equals(s.getUpwd())){
                session.setAttribute("user",s);
                return "paper";
            }
        }
        model.addAttribute("msg","账号或密码错误");
        return "login";
    }

    //跳转到注册页面
    @RequestMapping("/reg")
    public String reg(){
        return "reg";
    }


    //注册操作
    @RequestMapping("/zhuce")
    public String zhuce(ExamUser examUser,Model model){
        iUser.insertUser(examUser);
        model.addAttribute("msg","注册成功");
        return "login";
    }
}
