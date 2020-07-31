package com.sz.zhiling.modle;

public class Conferenceroom {
    private int crid;
    private int crno;
    private String crname;
    private String craddr;
    private String capacity;

    @Override
    public String toString() {
        return "Conferenceroom{" +
                "crid=" + crid +
                ", crno=" + crno +
                ", crname='" + crname + '\'' +
                ", craddr='" + craddr + '\'' +
                ", capacity='" + capacity + '\'' +
                '}';
    }

    public int getCrid() {
        return crid;
    }

    public void setCrid(int crid) {
        this.crid = crid;
    }

    public int getCrno() {
        return crno;
    }

    public void setCrno(int crno) {
        this.crno = crno;
    }

    public String getCrname() {
        return crname;
    }

    public void setCrname(String crname) {
        this.crname = crname;
    }

    public String getCraddr() {
        return craddr;
    }

    public void setCraddr(String craddr) {
        this.craddr = craddr;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public Conferenceroom() {
    }

    public Conferenceroom(int crid, int crno, String crname, String craddr, String capacity) {
        this.crid = crid;
        this.crno = crno;
        this.crname = crname;
        this.craddr = craddr;
        this.capacity = capacity;
    }
}
