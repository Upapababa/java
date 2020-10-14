package com.sz.zhiling.model;

public class ExamScoreDetail {

    public ExamScoreDetail(Integer scoreid, Integer eid, String uanswer, Integer upoint) {
        this.scoreid = scoreid;
        this.eid = eid;
        this.uanswer = uanswer;
        this.upoint = upoint;
    }

    public ExamScoreDetail() {
    }

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column exam_score_detail.detailid
     *
     * @mbggenerated
     */


    private Integer detailid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column exam_score_detail.scoreid
     *
     * @mbggenerated
     */
    private Integer scoreid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column exam_score_detail.eid
     *
     * @mbggenerated
     */
    private Integer eid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column exam_score_detail.uanswer
     *
     * @mbggenerated
     */
    private String uanswer;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column exam_score_detail.upoint
     *
     * @mbggenerated
     */
    private Integer upoint;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column exam_score_detail.detailid
     *
     * @return the value of exam_score_detail.detailid
     *
     * @mbggenerated
     */
    public Integer getDetailid() {
        return detailid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column exam_score_detail.detailid
     *
     * @param detailid the value for exam_score_detail.detailid
     *
     * @mbggenerated
     */
    public void setDetailid(Integer detailid) {
        this.detailid = detailid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column exam_score_detail.scoreid
     *
     * @return the value of exam_score_detail.scoreid
     *
     * @mbggenerated
     */
    public Integer getScoreid() {
        return scoreid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column exam_score_detail.scoreid
     *
     * @param scoreid the value for exam_score_detail.scoreid
     *
     * @mbggenerated
     */
    public void setScoreid(Integer scoreid) {
        this.scoreid = scoreid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column exam_score_detail.eid
     *
     * @return the value of exam_score_detail.eid
     *
     * @mbggenerated
     */
    public Integer getEid() {
        return eid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column exam_score_detail.eid
     *
     * @param eid the value for exam_score_detail.eid
     *
     * @mbggenerated
     */
    public void setEid(Integer eid) {
        this.eid = eid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column exam_score_detail.uanswer
     *
     * @return the value of exam_score_detail.uanswer
     *
     * @mbggenerated
     */
    public String getUanswer() {
        return uanswer;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column exam_score_detail.uanswer
     *
     * @param uanswer the value for exam_score_detail.uanswer
     *
     * @mbggenerated
     */
    public void setUanswer(String uanswer) {
        this.uanswer = uanswer == null ? null : uanswer.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column exam_score_detail.upoint
     *
     * @return the value of exam_score_detail.upoint
     *
     * @mbggenerated
     */
    public Integer getUpoint() {
        return upoint;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column exam_score_detail.upoint
     *
     * @param upoint the value for exam_score_detail.upoint
     *
     * @mbggenerated
     */
    public void setUpoint(Integer upoint) {
        this.upoint = upoint;
    }
}