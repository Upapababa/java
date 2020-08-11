package com.sz.zhiling.dao;

//import com.sz.zhiling.JDBC.MyUtil;

import com.sz.zhiling.model.Conferenceroom;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

//import com.sz.zhiling.servce.IShow;
//import org.apache.commons.dbutils.ResultSetHandler;
//import org.apache.commons.dbutils.handlers.ScalarHandler;
@Repository
public class ShowDao  {
    @Autowired
    private JdbcTemplate jdbcTemplate;

//    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
//        this.jdbcTemplate = jdbcTemplate;
//    }
//    public void setRunner(QueryRunner runner) {
//        this.runner = runner;
//    }

    public List<Conferenceroom> showAll(int page){
        String sql="select * from(\n" +
                "      select rownum rn , tt.*from(\n" +
                "           select * from conferenceroom order by crid asc \n" +
                "\t) tt where rownum<=?*4\n" +
                ") where rn>?*4";

        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Conferenceroom.class),page,page-1);


    }

    public int showAllpage(){
        String sql="select * from conferenceroom";
        List s= jdbcTemplate.query(sql,new BeanPropertyRowMapper(Conferenceroom.class));
        return s.size();
    }
}
