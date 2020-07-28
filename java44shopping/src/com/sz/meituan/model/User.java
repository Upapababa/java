package com.sz.meituan.model;

public class User {
    private int userid;
    private String uname;
    private String utele;
    private String uaddr;
    private String upwd;
    private int orderid;

    public int getOrderid() {
        return orderid;
    }

    public void setOrderid(int orderid) {
        this.orderid = orderid;
    }

    public User(int orderid) {
        this.orderid = orderid;
    }

    @Override
    public String toString() {
        return "User{" +
                "userid=" + userid +
                ", uname='" + uname + '\'' +
                ", utele='" + utele + '\'' +
                ", uaddr='" + uaddr + '\'' +
                ", upwd='" + upwd + '\'' +
                '}';
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUtele() {
        return utele;
    }

    public void setUtele(String utele) {
        this.utele = utele;
    }

    public String getUaddr() {
        return uaddr;
    }

    public void setUaddr(String uaddr) {
        this.uaddr = uaddr;
    }

    public String getUpwd() {
        return upwd;
    }

    public void setUpwd(String upwd) {
        this.upwd = upwd;
    }

    public User() {
    }

    public User(int userid, String uname, String utele, String uaddr, String upwd) {
        this.userid = userid;
        this.uname = uname;
        this.utele = utele;
        this.uaddr = uaddr;
        this.upwd = upwd;
    }
}
