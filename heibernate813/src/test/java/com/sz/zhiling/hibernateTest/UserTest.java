package com.sz.zhiling.hibernateTest;

import com.sz.zhiling.module.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.junit.Test;


public class UserTest {


    @Test
    public void testadd(){
        //无参表示核心文件按约定写
        Configuration configuration=new Configuration().configure();
        //注册服务与配置
        ServiceRegistry serviceRegistry=new StandardServiceRegistryBuilder().configure().build();
        //获得SessionFactory
        SessionFactory factory=configuration.buildSessionFactory(serviceRegistry);
        //获取Session
        Session session=factory.openSession();
        //获取事物
        Transaction transaction=null;
        //开启事务
        transaction=session.beginTransaction();
        //事务保存
//        session.save(new User("jack","123"));
//        删除
//        session.delete(new User("jack","123"));
//        查询
        User u= (User) session.get("jack","123");
        u.setUpwd("234");
        //事务提交(有缓存机制，提交最后的u对象所以密码是234)
        transaction.commit();
        //关闭session
        session.close();
    }

    @Test
    public void pageTest(){

    }


}
