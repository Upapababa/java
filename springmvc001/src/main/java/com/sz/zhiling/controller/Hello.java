package com.sz.zhiling.controller;


import com.sz.zhiling.dao.CityDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/hi")
public class Hello {

    @Autowired
    private CityDao cityDao;

    @RequestMapping("/h1")
    public String show(){
        System.out.println("springmvc 被调用");
        return "hello";
    }
}
