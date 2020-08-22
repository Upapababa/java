package com.sz.zhiling.model;

public class Myanswer extends ExamItems{

    private Integer detailid;
    private Integer scoreid;
    private String uanswer;
    private Integer upoint;

    public Myanswer() {
    }

    public Myanswer(Integer eid, String ename, Integer epaperid, Integer escore, Integer etype, Integer edegree, String ea, String eb, String ec, String ed, String ee, String ef, String ekeys, String ehints, Integer detailid, Integer scoreid, String uanswer, Integer upoint) {
        super(eid, ename, epaperid, escore, etype, edegree, ea, eb, ec, ed, ee, ef, ekeys, ehints);
        this.detailid = detailid;
        this.scoreid = scoreid;
        this.uanswer = uanswer;
        this.upoint = upoint;
    }

    public Integer getDetailid() {
        return detailid;
    }

    public void setDetailid(Integer detailid) {
        this.detailid = detailid;
    }

    public Integer getScoreid() {
        return scoreid;
    }

    public void setScoreid(Integer scoreid) {
        this.scoreid = scoreid;
    }

    public String getUanswer() {
        return uanswer;
    }

    public void setUanswer(String uanswer) {
        this.uanswer = uanswer;
    }

    public Integer getUpoint() {
        return upoint;
    }

    public void setUpoint(Integer upoint) {
        this.upoint = upoint;
    }
}