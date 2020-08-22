package com.sz.zhiling.service;

import com.sz.zhiling.mapper.ExamUserMapper;
import com.sz.zhiling.model.ExamUser;
import com.sz.zhiling.model.ExamUserExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserImlp implements IUser {
    @Autowired
    private ExamUserMapper examUserMapper;

    @Override
    public List<ExamUser> selectByUser(ExamUser examUser) {
        return examUserMapper.selectByExample(null);
    }

    @Override
    public int insertUser(ExamUser examUser) {
        return examUserMapper.insert(examUser);
    }
}
