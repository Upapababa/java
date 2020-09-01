package com.sz.zhiling.controller;

import com.sz.zhiling.model.TRouse;
import com.sz.zhiling.service.IRouse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/rouse")
@RestController
@Api(value = "/rouse",description = "角色管理")
public class RouseController {

    @Autowired
    private IRouse iRouse;


    @RequestMapping("/list")
    @ResponseBody
    @ApiOperation(value = "/查询角色",notes = "查询角色")
    public List<TRouse> getRouse(){
        return iRouse.getRouse();
    }
}
