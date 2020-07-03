package com.sz.zhiling.modal;

import java.sql.*;
import java.util.InputMismatchException;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Link_oracle {
    static ResourceBundle bundle = ResourceBundle.getBundle("jdbc");
    private static final  String driver = bundle.getString("driver");
    private static final  String url = bundle.getString("url");
    private static final  String user = bundle.getString("user");
    private static final  String pwd = bundle.getString("pwd");

    static Connection conn=null;
    static PreparedStatement sta=null;
    static ResultSet rs=null;
    static Scanner s = new Scanner(System.in);

    public static Connection lianjie(){
        try {
            Class.forName(driver);
            conn=DriverManager.getConnection(url,user,pwd);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static User panduan(int id){
        User user2 = null;
        conn=lianjie();
        try {
            String sql = "select * from t_atm";
            sta = conn.prepareStatement(sql);
            rs = sta.executeQuery();
            while (rs.next()){
                if(id==rs.getInt("mno")){
                    user2=new User(id,rs.getInt("mpwd"),rs.getInt("balance"),rs.getString("name"));
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
        }
        return user2;
    }

    public static User panduan(int mno,int mpwd){
        User user = null;
        conn=lianjie();
        try {
            String sql = "select * from t_atm";
            sta = conn.prepareStatement(sql);
            rs = sta.executeQuery();
            while (rs.next()){
                if(mno==rs.getInt("mno")&& mpwd==rs.getInt("mpwd")){
                    user=new User(mno,mpwd,rs.getInt("balance"),rs.getString("name"));
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
        }
        return user;
    }

    public static void Show(User f) {
        conn=lianjie();
        try {
            String sql = "select balance from t_atm where mno=?";
            sta = conn.prepareStatement(sql);
            sta.setObject(1,f.getMno());
            rs = sta.executeQuery();
            rs.next();
            System.out.println("您的余额为:"+rs.getInt("balance"));
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
        }
    }

    public static void xiugai(User f) {
        conn=lianjie();
        try {
            System.out.println("请输入原密码");
            int opwd = s.nextInt();
            if(opwd==f.getMpwd()){
                System.out.println("请输入新密码：");
                int npwd = s.nextInt();
                String sql = "update t_atm set mpwd=? where mno=?";
                sta = conn.prepareStatement(sql);
                sta.setObject(1,npwd);
                sta.setObject(2,f.getMno());
                int cc = sta.executeUpdate();
                if(cc==1){
                    System.out.println("修改密码成功！");
                    f.setMpwd(npwd);
                }else{
                    System.out.println("修改密码失败！！");
                }
            }else{
                System.out.println("密码输入错误！！");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }catch (InputMismatchException e){
            System.out.println("密码输入格式有误！");
            s.next();
        }
    }

    public static void cunkuan(User f) {
        conn=lianjie();
        try {
            System.out.println("请输入存款金额：");
            int jine = s.nextInt();
            int zje = f.getBalance()+jine;
            String sql = "update t_atm set balance=? where mno=?";
            sta = conn.prepareStatement(sql);
            sta.setObject(1,zje);
            sta.setObject(2,f.getMno());
            int cc = sta.executeUpdate();
            if(cc==1){
                System.out.println("存款成功！");
                f.setBalance(zje);
            }else{
                System.out.println("存款失败！！");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }catch (InputMismatchException e){
            System.out.println("输入格式有误！");
            s.next();
        }
    }

    public static void qukuan(User f) {
        conn=lianjie();
        try {
            System.out.println("请输入取款金额：");
            int jine = s.nextInt();
            int zje = f.getBalance()-jine;
            if(zje>1){
                String sql = "update t_atm set balance=? where mno=?";
                sta = conn.prepareStatement(sql);
                sta.setObject(1,zje);
                sta.setObject(2,f.getMno());
                int cc = sta.executeUpdate();
                if(cc==1){
                    System.out.println("取款成功！");
                    f.setBalance(zje);
                }else{
                    System.out.println("取款失败！！");
                }
            }else{
                System.out.println("余额不足！！");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }catch (InputMismatchException e){
            System.out.println("输入格式有误！");
            s.next();
        }
    }

    public static void zhuanzhang(User f) {
        conn=lianjie();
        try {
            System.out.println("请输入转账对象卡号：");
            int id = s.nextInt();
            User user2=panduan(id);
            if(user2!=null){
                System.out.println("请输入转账金额：");
                int jine = s.nextInt();
                int zje = f.getBalance()-jine;
                int zje2= user2.getBalance()+jine;
                if(zje>1){
                    String sql = "update t_atm set balance=? where mno=?";
                    sta = conn.prepareStatement(sql);
                    sta.setObject(1,zje);
                    sta.setObject(2,f.getMno());
                    int cc = sta.executeUpdate();
                    String sql2 = "update t_atm set balance=? where mno=?";
                    sta = conn.prepareStatement(sql);
                    sta.setObject(1,zje2);
                    sta.setObject(2,user2.getMno());
                    int cc2 = sta.executeUpdate();
                    if(cc==1){
                        System.out.println("转账成功！");
                        f.setBalance(zje);
                    }else{
                        System.out.println("转账失败！！");
                    }
                }else{
                    System.out.println("余额不足！！");
                }
            }else{
                System.out.println("卡号不存在！！！");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }catch (InputMismatchException e){
            System.out.println("输入格式有误！");
            s.next();
        }
    }

    public static void close(){
        if(sta!=null){
            try {
                sta.close();
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
