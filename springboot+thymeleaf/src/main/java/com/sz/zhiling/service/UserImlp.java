package com.sz.zhiling.service;

import com.sz.zhiling.mapper.TUserMapper;
import com.sz.zhiling.model.TUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserImlp implements IUser {

    @Autowired
    private TUserMapper tUserMapper;

    @Override
    public List<TUser> serachAll() {
        return tUserMapper.selectByExample(null);
    }
}
