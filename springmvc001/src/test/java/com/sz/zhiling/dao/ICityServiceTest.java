package com.sz.zhiling.dao;

import com.sz.zhiling.module.ResoultPage;
import com.sz.zhiling.service.CityImp;
import com.sz.zhiling.service.ICity;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ICityServiceTest {

    ClassPathXmlApplicationContext cx=new ClassPathXmlApplicationContext("applicationContext.xml");
    CityImp cityImp= (CityImp) cx.getBean("cityImp");

    @Test
    public void ICityTest(){
        System.out.println(cityImp.showAllCity(1));
        System.out.println(cityImp.showAllPage());
    }
    @Test
    public void pageTest(){
        ClassPathXmlApplicationContext cx=new ClassPathXmlApplicationContext("applicationContext.xml");
        ResoultPage resoultPage= (ResoultPage) cx.getBean("resoultPage");
        System.out.println(resoultPage);
    }
}
