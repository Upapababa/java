package com.sz.meituan.model;

import java.sql.Date;
import java.util.List;

public class Pin {
    private int pid;
    private int userid;
    private int fid;
    private String msg;
    private Date pdate;
    private String uname;
    private List list2;

    public List getList2() {
        return list2;
    }

    public void setList2(List list2) {
        this.list2 = list2;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
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

    public int getFid() {
        return fid;
    }

    public void setFid(int fid) {
        this.fid = fid;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Date getPdate() {
        return pdate;
    }

    public void setPdate(Date pdate) {
        this.pdate = pdate;
    }

    public Pin() {
    }

    public Pin(int pid, int userid, int fid, String msg, Date pdate, String uname) {
        this.pid = pid;
        this.userid = userid;
        this.fid = fid;
        this.msg = msg;
        this.pdate = pdate;
        this.uname = uname;
    }
}
