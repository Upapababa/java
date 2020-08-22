package com.sz.zhiling.service;

import com.sz.zhiling.model.ExamScoreDetail;

import java.util.List;

public interface IScoreDetail {
    Integer insertByexamScore(ExamScoreDetail examScoreDetail);

    List<ExamScoreDetail> selectByScoreid(Integer scoreid);
}
