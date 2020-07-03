package com.sz.zhiling.modal;

public class User {
    //账号
    private int mno;
    //密码
    private int mpwd;
    //余额
    private int balance;
    //姓名
    private String name;
    //等级
//    private int level;

    public User() {
    }

    public int getMno() {
        return mno;
    }

    public void setMno(int mno) {
        this.mno = mno;
    }

    public int getMpwd() {
        return mpwd;
    }

    public void setMpwd(int mpwd) {
        this.mpwd = mpwd;
    }

//    public int getLevel() {
//        return balance;
//    }
//
//    public void setLevel(int balance) {
//        this.balance = balance;
//    }



    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User(int mno, int mpwd, int balance, String name ) {
        this.mno = mno;
        this.mpwd = mpwd;
        this.balance = balance;
//        this.level = level;
        this.name = name;
    }
}
