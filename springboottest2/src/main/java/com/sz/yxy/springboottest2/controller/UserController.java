package com.sz.yxy.springboottest2.controller;

import com.sz.yxy.springboottest2.common.PageBean;
import com.sz.yxy.springboottest2.model.TUser;
import com.sz.yxy.springboottest2.service.IUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/user")
@RestController
public class UserController {

    @Autowired
    private IUser iUser;

    @RequestMapping("/list3")
    @ResponseBody
    public List<TUser> list3(){
        return iUser.getAllUser();
    }

    @RequestMapping("/list4")
    @ResponseBody
    public PageBean<TUser> getAllUsers4(int pageIndex, int pageSize){
        return  iUser.getAllUsersPage(pageIndex,pageSize);
    }


    @RequestMapping("/deleteUser")
    @ResponseBody
    public String deleteUser(int uid){
        System.out.println(uid);
        int s= iUser.deleteUser(uid);
        System.out.println(s);
        return s>0?"删除成功":"删除失败";
    }

    @RequestMapping("/searchAll")
    @ResponseBody
    public PageBean<TUser> searchAll(int pageIndex, int pageSize,@RequestBody(required = false) TUser tUser){
        return  iUser.getAllUsersPage2(pageIndex,pageSize,tUser);
    }

    @ResponseBody
    @RequestMapping("/tj")
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
    public String deleteAll(Integer [] uids){
        System.out.println(uids);
        int s=iUser.deleteAll(uids);
        return s>0?"删除成功":"删除失败";
    }

}
