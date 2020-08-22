package com.sz.zhiling.service;


import com.sz.zhiling.mapper.ExamPaperMapper;
import com.sz.zhiling.model.ExamPaper;
import com.sz.zhiling.model.ExamPaperExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaperImlp implements IPaper {

    @Autowired
    private ExamPaperMapper examPaperMapper;

    @Override
    public List getPaperByName(String papername) {
        if(papername==""){
            return examPaperMapper.selectByExample(null);
        }else {
            ExamPaperExample example=new ExamPaperExample();
            ExamPaperExample.Criteria criteria = example.createCriteria();
            criteria.andPapernameLike("%"+papername+"%");
            return examPaperMapper.selectByExample(example);
        }
    }

    @Override
    public ExamPaper getPaperById(Integer paperid) {
        return examPaperMapper.selectByPrimaryKey(paperid);
    }
}
