package com.sz.zhiling.text;

import java.lang.management.ManagementFactory;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class MyUtil {

//    public static void main(String[] args) {
//        for (Student student : show()) {
//            System.out.println(student);
//        }
//    }

    //关闭资源
//    public static void close(){
//        if(conn!=null){
//            try {
//                conn.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//    }

    //新增语句
    public static int add(Student s){
        Connection conn =getconn();
        String sql = "insert into student values(seq_student_sid.nextval,?,?,?,?,?)";
        PreparedStatement ps =null;
        try {
            ps=conn.prepareStatement(sql);
            ps.setObject(1,s.getSname());
            ps.setObject(2,s.getSage());
            ps.setObject(3,s.getSsex());
            ps.setObject(4,s.getSpwd());
            ps.setObject(5,s.getSclassno());
            int a=ps.executeUpdate();
            return a;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(ps!=null){
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(conn!=null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return 0;
    }

    //删除语句
    public static int del(String sid){
        Connection conn= getconn();
        String sql = "delete from student where sid=?";
        PreparedStatement ps =null;
        try {
            ps=conn.prepareStatement(sql);
            ps.setObject(1,Integer.parseInt(sid));
            int s=ps.executeUpdate();
            return s;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(ps!=null){
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(conn!=null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return 0;
    }

    //获得连接
    public static Connection getconn(){
        ResourceBundle bundle = ResourceBundle.getBundle("jdbc");
        String driver = bundle.getString("driver");
        String url = bundle.getString("url");
        String user = bundle.getString("user");
        String pwd = bundle.getString("pwd");
//        String driver = "oracle.jdbc.driver.OracleDriver";
//        String url = "jdbc:oracle:thin:@localhost:1521:orcl";
//        String user = "yin";
//        String pwd = "123456";
        Connection conn=null;
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url,user,pwd);
            return conn;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    //查询语句
    public static List<Student> show(String search){
        List<Student> list1 = new ArrayList<>();
        Connection conn = getconn();
        String sql=null;
        ResultSet rs = null;
        PreparedStatement ps =null;
        if(search!=null){
            sql="select * from student where sname like ? or ssex=? or sage=? or sclassno=? order by sid asc";
            try {
                ps = conn.prepareStatement(sql);
                ps.setObject(1,"%"+search+"%");
                ps.setObject(2,search);
                if(!panduan.isNumeric(search)){
                    ps.setObject(3,0);
                }else{
                    ps.setObject(3,search);
                }
                ps.setObject(4,search);
                rs = ps.executeQuery();
                while(rs.next()){
                    Student s = new Student(rs.getInt(1),rs.getString(2),rs.getInt(3),
                            rs.getString(4),rs.getInt(5),rs.getString(6));
                    list1.add(s);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                if(rs!=null){
                    try {
                        rs.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
                if(ps!=null){
                    try {
                        ps.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
                if(conn!=null){
                    try {
                        conn.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
//            close();
            }
        }else{
            sql="select * from student order by sid asc";
            try {
                ps = conn.prepareStatement(sql);
                rs = ps.executeQuery();
                while(rs.next()){
                    Student s = new Student(rs.getInt(1),rs.getString(2),rs.getInt(3),
                            rs.getString(4),rs.getInt(5),rs.getString(6));
                    list1.add(s);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                if(rs!=null){
                    try {
                        rs.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
                if(ps!=null){
                    try {
                        ps.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
                if(conn!=null){
                    try {
                        conn.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
//            close();
            }
        }
        return list1;
    }


    public static int update(int sid,String sname,int sage,String ssex,int spwd,String sclassno) {
        Connection conn =getconn();
        String sql = "update student set sname=?,sage=?,ssex=?,spwd=?,sclassno=? where  sid=?";
        PreparedStatement ps =null;
        try {
            ps=conn.prepareStatement(sql);
            ps.setObject(1,sname);
            ps.setObject(2,sage);
            ps.setObject(3,ssex);
            ps.setObject(4,spwd);
            ps.setObject(5,sclassno);
            ps.setObject(6,sid);
            int s=ps.executeUpdate();
            return s;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(ps!=null){
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(conn!=null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return 0;
    }
}
