package com.sz.yxy.springboottest2.controller;

import com.sz.yxy.springboottest2.model.TRouse;
import com.sz.yxy.springboottest2.service.IRouse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/rouse")
@RestController
public class RouseController {

    @Autowired
    private IRouse iRouse;


    @RequestMapping("/list")
    @ResponseBody
    public List<TRouse> getRouse(){
        return iRouse.getRouse();
    }
}
