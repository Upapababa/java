package com.sz.zhiling.model;

import java.sql.*;
import java.util.ResourceBundle;

public class Uitl {
    //获得连接
    public static Connection getconn(){
        ResourceBundle bundle = ResourceBundle.getBundle("jdbc");
        String driver = bundle.getString("driver");
        String url = bundle.getString("url");
        String user = bundle.getString("user");
        String pwd = bundle.getString("pwd");
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
    //查询余额
    public static Double show(String mno){
        Double balance = 0.0;
        Connection conn=getconn();
        int mno1 = Integer.parseInt(mno);
        ResultSet rs = null;
        PreparedStatement ps =null;
        String sql="select balance from t_atm where mno=? ";
        try {
            ps = conn.prepareStatement(sql);
            ps.setObject(1,mno1);
            rs = ps.executeQuery();
            while(rs.next()){
                balance=rs.getDouble(1);
                return balance;
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
        }
        return balance;
    }

    //判断是否存在
    public static User panduan(String mno,String mpwd) {
        User s=null;
        Connection conn=getconn();
        ResultSet rs = null;
        PreparedStatement ps =null;
        String sql="select * from t_atm order by mno asc";
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                if(rs.getString(1).equals(mno) && rs.getString(2).equals(mpwd)){
                    s = new User(rs.getInt(1),rs.getInt(2),rs.getDouble(3),
                            rs.getString(4));
                    return s;
                }
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
        }
        return s;
    }
    public static User panduan(String mno) {
        User s=null;
        Connection conn=getconn();
        ResultSet rs = null;
        PreparedStatement ps =null;
        String sql="select * from t_atm order by mno asc";
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                if(rs.getString(1).equals(mno)){
                    s = new User(rs.getInt(1),rs.getInt(2),rs.getDouble(3),
                            rs.getString(4));
                    return s;
                }
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
        }
        return s;
    }
    //转账
    public static void zz(Double balance2,int mno2,Double balance3,int mno3) {
        Connection conn = getconn();
        PreparedStatement ps =null;
        PreparedStatement ps1 =null;
        String sql="update t_atm set balance=? where mno=? ";
        String sql1="update t_atm set balance=? where mno=? ";
        try {
            conn.setAutoCommit(false);
            ps = conn.prepareStatement(sql);
            ps1 = conn.prepareStatement(sql1);
            ps.setObject(1,balance2);
            ps.setObject(2,mno2);
            ps1.setObject(1,balance3);
            ps1.setObject(2,mno3);
            int s =ps.executeUpdate();
            int d =ps1.executeUpdate();
            conn.commit();
        } catch (SQLException e) {
            try {
                conn.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
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
    }

    //存款
    public static void save(Double balance2,int mno2) {
        Connection conn = getconn();
        PreparedStatement ps =null;
        String sql="update t_atm set balance=? where mno=? ";
        try {
            ps = conn.prepareStatement(sql);
            ps.setObject(1,balance2);
            ps.setObject(2,mno2);
            int s =ps.executeUpdate();
            System.out.println(s==1?"存款成功":"存款失败");
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
    }

    public static void upd(String npwd,String mno) {
        Connection conn=getconn();
        int mno2 = Integer.parseInt(mno);
        int npwd1 = Integer.parseInt(npwd);
        PreparedStatement ps =null;
        String sql="update t_atm set mpwd=? where mno=? ";
        try {
            ps = conn.prepareStatement(sql);
            ps.setObject(1,npwd1);
            ps.setObject(2,mno2);
            int s =ps.executeUpdate();
            System.out.println(s==1?"修改密码成功":"修改密码失败");
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
    }
}
