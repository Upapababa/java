package com.sz.zhiling.text;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MyDao {
    private static QueryRunner runner = new QueryRunner(MyUtil.getComboPooledDataSource());

    public static List show(int page) {
//        int page1=Integer.parseInt(page);
        String sql = "select * from(\n" +
                "      select rownum rn , tt.*from(\n" +
                "           select s.sid,s.sname,s.sage,s.ssex,s.sclassno,\n" +
                "           t.tname from student s,teacher t where s.sclassno=t.sclassno order by s.sid asc \n" +
                ") tt where rownum<=?*5\n" +
                ") where rn>?*5";
        List u=new ArrayList();
        try {
            u=runner.query(sql,new BeanListHandler<>(User.class),page,page-1);
            return u;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return u;
    }
    public static int show1() {
//        int page1=Integer.parseInt(page);
        String sql = "select s.sid,s.sname,s.sage,s.ssex,s.sclassno,t.tname from student s,teacher t where s.sclassno=t.sclassno order by s.sid asc";
        List u=new ArrayList();
        try {
            u=runner.query(sql,new BeanListHandler<>(User.class));
            int s=u.size()%5==0?(u.size()/5):(u.size()/5+1);
            return s;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static void del(String sid) {
        String sql="delete from student where sid=?";
        try {
            runner.update(sql,sid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void del(String[] sid) {
        for (String s:sid) {
            String sql="delete from student where sid=?";
            try {
                runner.update(sql,s);
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }

    public static void add(User s) {
        String sql = "insert into student values(seq_student_sid.nextval,?,?,?,?,?)";
        try {
            runner.update(sql,s.getSname(),s.getSage(),s.getSsex(),s.getPwd(),s.getSclassno());
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void upd(int sid, String sname, int sage, String ssex, String sclassno) {
        String sql = "update student set sname=?,sage=?,ssex=?,sclassno=? where  sid=?";
        try {
            runner.update(sql,sname,sage,ssex,sclassno,sid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
