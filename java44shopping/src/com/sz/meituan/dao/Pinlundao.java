package com.sz.meituan.dao;

import com.sz.meituan.dbutils.DBUtils;
import com.sz.meituan.model.Food;
import com.sz.meituan.model.Huifu;
import com.sz.meituan.model.Pin;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Pinlundao {
    private QueryRunner runner = new QueryRunner(DBUtils.getDataSource());

    public List<Pin> chaxun(String fid){
        List list = new ArrayList();
        String sql="select * from upingjia where fid=? order by pid desc";
        try {
            list=runner.query(sql,new BeanListHandler<>(Pin.class),fid);
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    public Food chaxun2(String fid) {
        String sql="select * from food where fid=?";
        try {
            return runner.query(sql,new BeanHandler<>(Food.class),Integer.parseInt(fid));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void pp(String fid, String msg, int userid, String uname) {
        String sql="insert into upingjia values(pin_seq_pid.nextval,?,?,?,sysdate,?)";
        try {
            runner.update(sql,userid,Integer.parseInt(fid),msg,uname);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Huifu> cha(int ppid) {
        String sql = "select * from appraise where pid = ?";
        try {
            return  runner.query(sql,new BeanListHandler<>(Huifu.class),ppid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
