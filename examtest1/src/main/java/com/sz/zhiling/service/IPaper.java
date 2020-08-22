package com.sz.zhiling.service;

import com.sz.zhiling.model.ExamPaper;

import java.util.List;

public interface IPaper {
    List getPaperByName(String papername);

    ExamPaper getPaperById(Integer paperid);
}
