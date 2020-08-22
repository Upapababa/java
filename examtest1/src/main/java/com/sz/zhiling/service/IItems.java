package com.sz.zhiling.service;

import com.sz.zhiling.model.ExamItems;

import java.util.List;

public interface IItems {
    List<ExamItems> selectByPaperid(int paperid);

    ExamItems getKeys(Integer ss);

    ExamItems getItemsById(Integer paperid);

}
