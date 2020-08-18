package com.sz.zhiling.controller;


import com.sz.zhiling.module.User;
import com.sz.zhiling.service.IUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/showUser")
public class UserController {

    @Autowired
    private IUser iUser;


    @RequestMapping("/ss")
    public String start1(){
//        System.out.println("=====================");
        return "exem";
    }

    @RequestMapping("/showAllUser")
    @ResponseBody
    public List getAllList1(){
        List list = iUser.getAllUser();
        return list;
    }

    @RequestMapping("/dele")
    @ResponseBody
    public String deleteUser(@RequestParam("uid") int uid){
        int n =iUser.deleteUser(uid);
        return n>0?"删除成功":"删除失败";
    }
//
    @RequestMapping("/upde")
    @ResponseBody
    public String updUser(@RequestParam("uids") Integer uids,@RequestParam("uname") String uname,@RequestParam("upwd") String upwd){
        try{
            //修改用户
            User user=new User(uids,uname,upwd);
            int n=iUser.updeteUser(user);
            return n>0?"修改成功":"修改失败";
        }catch (Exception e){
            //添加用户
            User user=new User(uname,upwd);
            int s=iUser.addUser(user);
            return s>0?"添加成功":"添加失败";
        }

//        if(uid!="" || uid!=null){
////            修改用户
//            User user=new User(uid,uname,upwd);
//            int n=iUser.updeteUser(user);
//            return n>0?"修改成功":"修改失败";
//        }else{
//            //添加用户
//            User user=new User(uname,upwd);
//            int s=iUser.addUser(user);
//            return s>0?"添加成功":"添加失败";
//        }
      }
}
