package com.sz.meituan.model;

import java.util.Date;
import java.util.List;

public class Huifu {
    private int aid;
    private int pid;
    private int userid;
    private String amsg;
    private Date adate;
    private String uname;
    private List<Huifu> list2;

    public Huifu(int aid, int pid, int userid, String amsg, Date adate, String uname) {
        this.aid = aid;
        this.pid = pid;
        this.userid = userid;
        this.amsg = amsg;
        this.adate = adate;
        this.uname = uname;
    }

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getAmsg() {
        return amsg;
    }

    public void setAmsg(String amsg) {
        this.amsg = amsg;
    }

    public Date getAdate() {
        return adate;
    }

    public void setAdate(Date adate) {
        this.adate = adate;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public List<Huifu> getList2() {
        return list2;
    }

    public void setList2(List<Huifu> list2) {
        this.list2 = list2;
    }

    public Huifu() {
    }

    public Huifu(int aid, int pid, int userid, String amsg, Date adate, String uname, List<Huifu> list2) {
        this.aid = aid;
        this.pid = pid;
        this.userid = userid;
        this.amsg = amsg;
        this.adate = adate;
        this.uname = uname;
        this.list2 = list2;
    }
}
