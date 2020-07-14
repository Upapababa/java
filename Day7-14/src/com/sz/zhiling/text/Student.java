package com.sz.zhiling.text;

public class Student {
    private  int sid;
    private  String sname;
    private  int sage;
    private  String ssex;
    private int spwd;
    private String sclassno;

    public Student(int sid, String sname, int sage, String ssex, int spwd, String sclassno) {
        this.sid = sid;
        this.sname = sname;
        this.sage = sage;
        this.ssex = ssex;
        this.spwd = spwd;
        this.sclassno = sclassno;
    }
    public Student( String sname, int sage, String ssex, int spwd, String sclassno) {
        this.sname = sname;
        this.sage = sage;
        this.ssex = ssex;
        this.spwd = spwd;
        this.sclassno = sclassno;
    }

    public Student() {
    }

    @Override
    public String toString() {
        return "Student{" +
                "sid=" + sid +
                ", sname='" + sname + '\'' +
                ", sage=" + sage +
                ", ssex='" + ssex + '\'' +
                ", spwd=" + spwd +
                ", sclassno='" + sclassno + '\'' +
                '}';
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

    public int getSpwd() {
        return spwd;
    }

    public void setSpwd(int spwd) {
        this.spwd = spwd;
    }

    public String getSclassno() {
        return sclassno;
    }

    public void setSclassno(String sclassno) {
        this.sclassno = sclassno;
    }
}
