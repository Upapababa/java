package com.sz.meituan.dao;

import com.sz.meituan.dbutils.DBUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.omg.CORBA.PUBLIC_MEMBER;

import java.sql.SQLException;

public class HuifuDao {
    private QueryRunner runner = new QueryRunner(DBUtils.getDataSource());

    public int huifu(int pid,int userid,String amsg,String uname){
        String sql="insert into appraise values(app_seq_aid.nextval,?,?,?,sysdate,?)";
        try {
            return runner.update(sql,pid,userid,amsg,uname);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
