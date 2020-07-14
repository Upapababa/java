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
    public static List<Student> show(){
        List<Student> list1 = new ArrayList<>();
        Connection conn = getconn();
        String sql="select * from student";
        ResultSet rs = null;
        PreparedStatement ps =null;
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
        }
        return list1;
    }


}
