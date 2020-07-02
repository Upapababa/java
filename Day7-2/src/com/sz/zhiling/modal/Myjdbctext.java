package com.sz.zhiling.modal;

import java.sql.*;
import java.util.Scanner;
//import static java.lang.Class.forName;

public class Myjdbctext {
    static Statement stat = null;
    static Connection conn = null;
    static ResultSet rs =null;
    public static void main(String[] args) {
        try {
            //注册驱动
            Driver driver =new oracle.jdbc.driver.OracleDriver();
//            DriverManager.registerDriver(driver);
            Class.forName("oracle.jdbc.driver.OracleDriver");
            //获取连接
            String url="jdbc:oracle:thin:@localhost:1521:orcl";
            String user="yin";
            String pwd="123456";
            conn = DriverManager.getConnection(url,user,pwd);
            //连接地址：oracle.jdbc.driver.T4CConnection@1cf4f579
            System.out.println("数据库连接："+conn);
            //获取数据库操作对象(Statement执行sql语句 )
            stat =conn.createStatement();
            // 执行sql语句
//            String sql = "insert into t_savingtype values(5,'现金','现金')";
//            int count = stat.executeUpdate(sql);
//            stat.executeQuery(sql);
//            System.out.println(count==1?"成功":"失败");

//            System.out.println("请输入要操作的语句：");
//            Scanner input =new Scanner(System.in);
//            String sql = input.nextLine();
//            add(sql);

            String sql = "select * from t_savingtype ";
            rs = stat.executeQuery(sql);
//            rs.next();
//            System.out.println(rs.getString(1));
            while(rs.next()){
                String sid = rs.getString("savingid");
                String sname = rs.getString("savingname");
                String did = rs.getString("descrip");
                System.out.println(sid+","+sname+","+did);
            }


        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if( stat != null ){
                try {
                    stat.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if( conn != null ){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

//    private static void add(String sql) {
////        String sl = sql;
//        try {
//            int count = stat.executeUpdate(sql);
//            System.out.println(count==1?"成功":"失败");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
}
