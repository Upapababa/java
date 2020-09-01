package com.sz.yxy.springboottest2.service;

import com.sz.yxy.springboottest2.common.PageBean;
import com.sz.yxy.springboottest2.model.TUser;

import java.util.List;

public interface IUser {
    List<TUser> getAllUser();

    PageBean<TUser> getAllUsersPage(int pageIndex, int pageSize);

    int deleteUser(int uid);

    PageBean<TUser> getAllUsersPage2(int pageIndex, int pageSize, TUser tUser);

    int insertUser(TUser tUser);

    int updetaUser(TUser tUser);

    int deleteAll(Integer[] uids);
}
