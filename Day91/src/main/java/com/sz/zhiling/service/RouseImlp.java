package com.sz.zhiling.service;

import com.sz.zhiling.mapper.TRouseMapper;
import com.sz.zhiling.model.TRouse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RouseImlp implements IRouse {

    @Autowired
    private TRouseMapper tRouseMapper;

    @Override
    public List<TRouse> getRouse() {
        return tRouseMapper.selectByExample(null);
    }
}
