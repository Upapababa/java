package com.sz.zhiling.dao;

import com.sz.zhiling.JDBC.MyUtil;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.SQLException;

public class UPDao {
    private QueryRunner runner = new QueryRunner(MyUtil.getDataSource());
    //增加会议信息
    public int add(String crno, String crname, String craddr, String capacity) {
        String sql="insert into conferenceroom values(cr_seq_crid.nextval,?,?,?,?)";
        try {
            return runner.update(sql,Integer.parseInt(crno),crname,craddr,capacity);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
    //修改会议信息
    public int upd(String crid, String crno, String crname, String craddr, String capacity) {
        String sql="update conferenceroom set crno=?,crname=?,craddr=?,capacity=? where crid=?";
        try {
            return runner.update(sql,Integer.parseInt(crno),crname,craddr,capacity,Integer.parseInt(crid));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
    //删除一条会议室信息
    public int del(String crid) {
        String sql="delete from conferenceroom where  crid=?";
        try {
            return runner.update(sql,crid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
