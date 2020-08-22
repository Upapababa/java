package com.sz.zhiling.service;

import com.sz.zhiling.model.ExamScore;

import java.util.List;

public interface IScore {
    int insertByExamScore(ExamScore examScore);

    List<ExamScore> getMyItems(Integer paperid, Integer userid);
}
