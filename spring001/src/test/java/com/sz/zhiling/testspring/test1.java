package com.sz.zhiling.testspring;

import com.sz.zhiling.service.IShow;
import com.sz.zhiling.service.IShowImp;
import com.sz.zhiling.service.IUP;
import com.sz.zhiling.service.IUPimp;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test1 {
    @Test
    public void test001(){
        ClassPathXmlApplicationContext cx=new ClassPathXmlApplicationContext("applicationContext.xml");
        IShow iShow= (IShowImp) cx.getBean("iShowImp");
        System.out.println(iShow.showAllpage());
    }
}
