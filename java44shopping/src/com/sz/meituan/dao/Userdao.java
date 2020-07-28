package com.sz.meituan.dao;

import com.sz.meituan.dbutils.DBUtils;
import com.sz.meituan.model.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

public class Userdao {
    private QueryRunner runner = new QueryRunner(DBUtils.getDataSource());

    public User getuser(String uname,String upwd){
        String sql="select * from users where uname=? and upwd=?";
        User u=null;
        try {
            u=runner.query(sql,new BeanHandler<>(User.class),uname,Integer.parseInt(upwd));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return u;
    }
}
