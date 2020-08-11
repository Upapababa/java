package com.sz.zhiling.dao;

//import com.sz.zhiling.JDBC.MyUtil;
//import com.sz.zhiling.servce.IUP;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;

@Repository
public class UPDao  {
//    private QueryRunner runner;
    @Autowired
    private JdbcTemplate jdbcTemplate;

//    public void setRunner(QueryRunner runner) {
//        this.runner = runner;
//    }

    //增加会议信息
    public int add(String crno, String crname, String craddr, String capacity) {
        String sql="insert into conferenceroom values(cr_seq_crid.nextval,?,?,?,?)";
//        try {
//            return runner.update(sql,Integer.parseInt(crno),crname,craddr,capacity);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
        return jdbcTemplate.update(sql,Integer.parseInt(crno),crname,craddr,capacity);
//        return 0;
    }
    //修改会议信息
    public int upd(String crid, String crno, String crname, String craddr, String capacity) {
        String sql="update conferenceroom set crno=?,crname=?,craddr=?,capacity=? where crid=?";
//        try {
//            return runner.update(sql,Integer.parseInt(crno),crname,craddr,capacity,Integer.parseInt(crid));
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return 0;
        return jdbcTemplate.update(sql,Integer.parseInt(crno),crname,craddr,capacity,Integer.parseInt(crid));
    }
    //删除一条会议室信息
    public int del(String crid) {
        String sql="delete from conferenceroom where  crid=?";
//        try {
//            return runner.update(sql,crid);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return 0;
        return jdbcTemplate.update(sql,crid);
    }
}
