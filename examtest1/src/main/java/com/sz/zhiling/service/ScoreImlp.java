package com.sz.zhiling.service;


import com.sz.zhiling.mapper.ExamScoreMapper;
import com.sz.zhiling.model.ExamScore;
import com.sz.zhiling.model.ExamScoreExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScoreImlp implements IScore {

    @Autowired
    private ExamScoreMapper examScoreMapper;


    @Override
    public int insertByExamScore(ExamScore examScore) {

        return examScoreMapper.add123(examScore);
    }

    @Override
    public List<ExamScore> getMyItems(Integer paperid, Integer userid) {
        ExamScoreExample example=new ExamScoreExample();
        ExamScoreExample.Criteria criteria = example.createCriteria();
        criteria.andPaperidEqualTo(paperid);
        criteria.andUseridEqualTo(userid);
        return examScoreMapper.selectByExample(example);
    }
}
