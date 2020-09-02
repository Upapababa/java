package com.sz.zhiling.crotroller;

import com.sz.zhiling.service.IUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUser iUser;

    @RequestMapping("/list")
    public String getUser(Model model){
        model.addAttribute("list",iUser.serachAll());
        return "user";
    }
}
