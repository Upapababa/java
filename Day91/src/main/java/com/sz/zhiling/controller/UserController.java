package com.sz.zhiling.controller;

import com.sz.zhiling.common.PageBean;
import com.sz.zhiling.model.TUser;
import com.sz.zhiling.service.IUser;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/user")
@RestController
@Api(value = "/user",description = "用户信息管理")
public class UserController {

    @Autowired
    private IUser iUser;

    @RequestMapping("/list3")
    @ResponseBody
    @ApiOperation(value = "/查询所有用户信息",notes = "查询所有用户信息")
    public List<TUser> list3(){
        return iUser.getAllUser();
    }

    @RequestMapping("/list4")
    @ResponseBody
    @ApiOperation(value = "/分页查询所有用户信息",notes = "分页查询所有用户信息")
    public PageBean<TUser> getAllUsers4(int pageIndex, int pageSize){
        return  iUser.getAllUsersPage(pageIndex,pageSize);
    }


    @RequestMapping("/deleteUser")
    @ResponseBody
    @ApiOperation(value = "/删除一个用户信息",notes = "删除一个用户信息")
    public String deleteUser(int uid){
        System.out.println(uid);
        int s= iUser.deleteUser(uid);
        System.out.println(s);
        return s>0?"删除成功":"删除失败";
    }

    @RequestMapping("/searchAll")
    @ResponseBody
    @ApiOperation(value = "/带条件分页查询用户信息",notes = "带条件分页查询用户信息")
    public PageBean<TUser> searchAll(int pageIndex, int pageSize,@RequestBody(required = false) TUser tUser){
        return  iUser.getAllUsersPage2(pageIndex,pageSize,tUser);
    }

    @ResponseBody
    @RequestMapping("/tj")
    @ApiOperation(value = "/添加或修改用户信息",notes = "添加或修改用户信息")
    public String tj(@RequestBody(required = false) TUser tUser){
        if(tUser.getUid()==0){
            //添加
            int s=iUser.insertUser(tUser);
            return s>0?"添加成功":"添加失败";
        }else{
            int s=iUser.updetaUser(tUser);
            return s>0?"修改成功":"修改失败";
        }
    }

    @RequestMapping("/deleteAll")
    @ResponseBody
    @ApiOperation(value = "/批量删除用户",notes = "批量删除用户")
    public String deleteAll(Integer [] uids){
        System.out.println(uids);
        int s=iUser.deleteAll(uids);
        return s>0?"删除成功":"删除失败";
    }

}
