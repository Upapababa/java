package com.sz.zhiling.model;

public class User {
    private int mno;
    private int mpwd;
    private double balance;
    private String mname;

    public User(int mno, int mpwd, double balance, String mname) {
        this.mno = mno;
        this.mpwd = mpwd;
        this.balance = balance;
        this.mname = mname;
    }

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

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }
}
