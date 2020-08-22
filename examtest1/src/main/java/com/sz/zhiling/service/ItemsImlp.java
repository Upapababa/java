package com.sz.zhiling.service;

import com.sz.zhiling.mapper.ExamItemsMapper;
import com.sz.zhiling.model.ExamItems;
import com.sz.zhiling.model.ExamItemsExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemsImlp implements IItems {

    @Autowired
    private ExamItemsMapper examItemsMapper;

    @Override
    public List<ExamItems> selectByPaperid(int paperid) {
        ExamItemsExample example=new ExamItemsExample();
        ExamItemsExample.Criteria criteria = example.createCriteria();
        criteria.andEpaperidEqualTo(paperid);
        return examItemsMapper.selectByExample(example);
    }

    @Override
    public ExamItems getKeys(Integer ss) {
        return examItemsMapper.selectByPrimaryKey(ss);
    }

    @Override
    public ExamItems getItemsById(Integer paperid) {
        return examItemsMapper.selectByPrimaryKey(paperid);
    }
}
