package com.sz.zhiling.model;

public class ExamIII extends ExamScore{

    private String papername;
    private String remarks;

    public ExamIII(Integer scoreid,Integer userid, Integer paperid, Integer score, Integer rights, Integer errors, String papername, String remarks) {
        super(scoreid,userid, paperid, score, rights, errors);
        this.papername = papername;
        this.remarks = remarks;
    }

    public ExamIII() {
    }

    public String getPapername() {
        return papername;
    }

    public void setPapername(String papername) {
        this.papername = papername;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}

