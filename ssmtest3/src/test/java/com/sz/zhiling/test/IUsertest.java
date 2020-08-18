package com.sz.zhiling.test;

import com.sz.zhiling.service.IUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class IUsertest {

    @Autowired
    private IUser iUser;

    @Test
    public void test(){

        System.out.println(iUser.getAllUser());
    }
}
