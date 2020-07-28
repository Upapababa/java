package com.sz.meituan.dao;

import com.sz.meituan.dbutils.DBUtils;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.SQLException;

public class Updao {
    private QueryRunner runner = new QueryRunner(DBUtils.getDataSource());

    public void upd(String utele,String uaddr,int userid ,String beizhu,String orderid){
        String sql="updete users set utele=?,uaddr=? where userid=?";
        String sql1="updete orderform set otype='已支付',beizhu=? where orderid=?";
        try {
            runner.update(sql,utele,uaddr,userid);
            runner.update(sql1,beizhu,Integer.parseInt(orderid));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
