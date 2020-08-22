package com.sz.zhiling.service;


import com.sz.zhiling.mapper.ExamScoreDetailMapper;
import com.sz.zhiling.model.ExamScoreDetail;
import com.sz.zhiling.model.ExamScoreDetailExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScoreDetailImlp  implements IScoreDetail{

    @Autowired
    private ExamScoreDetailMapper examScoreDetailMapper;


    @Override
    public Integer insertByexamScore(ExamScoreDetail examScoreDetail) {
        return examScoreDetailMapper.insert(examScoreDetail);
    }

    @Override
    public List<ExamScoreDetail> selectByScoreid(Integer scoreid) {
        ExamScoreDetailExample example=new ExamScoreDetailExample();
        ExamScoreDetailExample.Criteria criteria = example.createCriteria();
        criteria.andScoreidEqualTo(scoreid);
        return examScoreDetailMapper.selectByExample(example);
    }
}
