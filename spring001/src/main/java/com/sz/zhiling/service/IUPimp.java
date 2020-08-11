package com.sz.zhiling.service;

import com.sz.zhiling.dao.UPDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IUPimp implements IUP {
    @Autowired
    UPDao upDao;

//    public void setUpDao(UPDao upDao) {
//        this.upDao = upDao;
//    }

    @Override
    public int add(String crno, String crname, String craddr, String capacity) {
        return upDao.add(crno,crname,craddr,capacity);
    }

    @Override
    public int upd(String crid, String crno, String crname, String craddr, String capacity) {
        return upDao.upd(crid,crno,crname,craddr,capacity);
    }

    @Override
    public int del(String crid) {
        return upDao.del(crid);
    }
}
