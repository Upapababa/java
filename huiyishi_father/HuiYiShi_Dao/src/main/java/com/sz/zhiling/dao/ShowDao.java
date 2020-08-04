package com.sz.zhiling.dao;

import com.sz.zhiling.JDBC.MyUtil;
import com.sz.zhiling.modle.Conferenceroom;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

//import org.apache.commons.dbutils.ResultSetHandler;

public class ShowDao  {

    private QueryRunner runner = new QueryRunner(MyUtil.getDataSource());

    public List<Conferenceroom> showAll(int page){
        String sql="select * from(\n" +
                "      select rownum rn , tt.*from(\n" +
                "           select * from conferenceroom order by crid asc \n" +
                "\t) tt where rownum<=?*4\n" +
                ") where rn>?*4";
        try {
            return runner.query(sql,new BeanListHandler<>(Conferenceroom.class),page,page-1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public int showAllpage(){
        String sql="select * from conferenceroom";
        try {
            List s=runner.query(sql,new BeanListHandler<>(Conferenceroom.class));
            return s.size();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
