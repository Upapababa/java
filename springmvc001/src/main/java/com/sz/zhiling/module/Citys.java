package com.sz.zhiling.module;

public class Citys {

    private int aid;
    private String aname;
    private int fid;

    public Citys() {

    }

    public Citys(int aid, String aname, int fid) {
        this.aid = aid;
        this.aname = aname;
        this.fid = fid;
    }

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    public int getFid() {
        return fid;
    }

    public void setFid(int fid) {
        this.fid = fid;
    }
}

