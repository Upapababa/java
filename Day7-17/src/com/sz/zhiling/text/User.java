package com.sz.zhiling.text;

public class User {
    private int sid;
    private String sname;
    private int sage;
    private String ssex;
    private int pwd;
    private String sclassno;
    private String tname;

    public User(String sname, int sage, String ssex, String sclassno,int pwd) {
        this.sname = sname;
        this.sage = sage;
        this.ssex = ssex;
        this.sclassno = sclassno;
        this.pwd=pwd;
    }

    public int getPwd() {
        return pwd;
    }

    public void setPwd(int pwd) {
        this.pwd = pwd;
    }

    public User() {
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public int getSage() {
        return sage;
    }

    public void setSage(int sage) {
        this.sage = sage;
    }

    public String getSsex() {
        return ssex;
    }

    public void setSsex(String ssex) {
        this.ssex = ssex;
    }

    public String getSclassno() {
        return sclassno;
    }

    public void setSclassno(String sclassno) {
        this.sclassno = sclassno;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public User(int sid, String sname, int sage, String ssex, String sclassno, String tname) {
        this.sid = sid;
        this.sname = sname;
        this.sage = sage;
        this.ssex = ssex;
        this.sclassno = sclassno;
        this.tname = tname;
    }
}
