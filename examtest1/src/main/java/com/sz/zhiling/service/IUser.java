package com.sz.zhiling.service;

import com.sz.zhiling.model.ExamUser;

import java.util.List;

public interface IUser {
    List<ExamUser> selectByUser(ExamUser examUser);

    int insertUser(ExamUser examUser);
}
