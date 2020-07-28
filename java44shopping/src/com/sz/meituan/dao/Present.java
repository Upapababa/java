package com.sz.meituan.dao;

import com.sz.meituan.dbutils.DBUtils;
import com.sz.meituan.model.OrderForm;
import com.sz.meituan.model.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import javax.print.DocFlavor;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Present {
    private QueryRunner runner = new QueryRunner(DBUtils.getDataSource());

    public void tijiao(int orderid,int userid,Float total,int sum){
        String sql="insert into orderform values(?,?,'待支付',?,?,'')";
        try {
            runner.update(sql,orderid,userid,total,sum);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void tijiao2(int orderid,int fid, int num, float xiaoji) {
        String sql ="insert into ofdetails values(of_seq_ofid.nextval,?,?,?,?)";
        try {
            runner.update(sql,orderid,fid,num,xiaoji);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int chaxun1() {
//        User u=null;
        String sql ="select of_seq_ofid.nextval from dual";
        try {
            Object u=runner.query(sql,new ScalarHandler());
            return Integer.parseInt(u.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public List chaxun2(int orderid) {
        List list =new ArrayList();
        String sql = "select fname,fprice,num,xiaoji from ofdetails ofd inner join food f on f.fid=ofd.fid where orderid=?";
        try {
            list=runner.query(sql,new BeanListHandler<>(OrderForm.class),orderid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
