package com.sz.zhiling.dao;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.WebApplicationContextUtils;


public class CityDaoTest {


    ClassPathXmlApplicationContext cx=new ClassPathXmlApplicationContext("applicationContext.xml");
    CityDao cityDao= (CityDao) cx.getBean("cityDao");



//    测试dao层
    @Test
    public void cityDaoTest(){
        System.out.println(cityDao.showAllPage());
        System.out.println(cityDao.showAllCity(1));
    }
}
