package com.sz.yxy.springboottest2.service;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.sz.yxy.springboottest2.common.PageBean;
import com.sz.yxy.springboottest2.mapper.TUserMapper;
import com.sz.yxy.springboottest2.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class UserImlp implements IUser{

    @Autowired
    private TUserMapper tUserMapper;


    @Override
    public List<TUser> getAllUser() {
        return tUserMapper.selectByExample(null);
    }

    @Override
    public PageBean<TUser> getAllUsersPage(int pageIndex, int pageSize) {
        PageHelper.startPage(pageIndex,pageSize);
        List<TUser> list = tUserMapper.selectByExample(null); //查询所有的用户信息；
        Page<TUser> plist = (Page<TUser>) list;
        PageBean<TUser> pb = new PageBean<>(
                plist.getTotal(),
                plist.getResult(),
                plist.getPageSize(),
                plist.getPages(),
                plist.getPageNum()
        );
        return pb;
    }

    @Override
    public int deleteUser(int uid) {

        return tUserMapper.deleteByPrimaryKey(uid);
    }

    @Override
    public PageBean<TUser> getAllUsersPage2(int pageIndex, int pageSize, TUser tUser) {
        TUserExample example=new TUserExample();
        TUserExample.Criteria criteria = example.createCriteria();
        if(tUser.getUname()!=null){
            criteria.andUnameLike("%"+tUser.getUname()+"%");
        }
        if(tUser.getRid()>0){
            criteria.andRidEqualTo(tUser.getRid());
        }
        PageHelper.startPage(pageIndex,pageSize);
        List<TUser> list = tUserMapper.selectByExample(example); //查询所有的用户信息；
        Page<TUser> plist = (Page<TUser>) list;
        PageBean<TUser> pb = new PageBean<>(
                plist.getTotal(),
                plist.getResult(),
                plist.getPageSize(),
                plist.getPages(),
                plist.getPageNum()
        );
        return pb;
    }

    @Override
    public int insertUser(TUser tUser) {
        return tUserMapper.insert(tUser);
    }

    @Override
    public int updetaUser(TUser tUser) {
        return tUserMapper.updateByPrimaryKey(tUser);
    }

    @Override
    public int deleteAll(Integer[] uids) {
        if(uids.length!=0){
            TUserExample example=new TUserExample();
            TUserExample.Criteria criteria = example.createCriteria();
            criteria.andUidIn(Arrays.asList(uids));
            return tUserMapper.deleteByExample(example);
        }
        return 0;
    }
}
