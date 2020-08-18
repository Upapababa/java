package com.sz.zhiling.service;

import com.sz.zhiling.mapper.IUserdao;
import com.sz.zhiling.module.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserImp implements IUser {

    @Autowired
    private IUserdao iUserdao;

    @Override
    public List getAllUser() {
        return iUserdao.getAllUser();
    }

    @Override
    public int deleteUser(int uid) {
        return iUserdao.deleteUser(uid);
    }

    @Override
    public int updeteUser(User user) {
        return iUserdao.updeteUser(user);
    }

    @Override
    public int addUser(User user) {
        return iUserdao.addUser(user);
    }
}
