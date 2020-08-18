package com.sz.zhiling.service;

import com.sz.zhiling.module.User;

import java.util.List;

public interface IUser {

    public List getAllUser();

    public int deleteUser(int uid);

    public int updeteUser(User user);

    public int addUser(User user);
}
