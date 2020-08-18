package com.sz.zhiling.mapper;


import com.sz.zhiling.module.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUserdao {

    public List<User> getAllUser();

    public int addUser(User user);
//
    public int deleteUser(int uid);

    public int updeteUser(User user);
}
