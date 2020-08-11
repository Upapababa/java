package com.sz.zhiling.service;

import com.sz.zhiling.dao.CityDao;
import com.sz.zhiling.module.Citys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityImp implements ICity{

    @Autowired
    private CityDao cityDao;

    @Override
    public List<Citys> showAllCity(int page) {
        return cityDao.showAllCity(page);
    }

    @Override
    public int showAllPage() {
        return cityDao.showAllPage();
    }

    @Override
    public String showCityName(int fid) {
        return cityDao.showCityName(fid);
    }

    @Override
    public int addPname(String pname) {
        return cityDao.addPname(pname);
    }

    @Override
    public int showAid(String pname) {
        return cityDao.showAid(pname);
    }

    @Override
    public int addCname(String cname, int aid) {
        return cityDao.addCname(cname,aid);
    }

    @Override
    public int updpname(String pname,String aid) {
        return cityDao.updpname(pname,aid);
    }

    @Override
    public int updCity(String cname, int fid, String aid) {
        return cityDao.updCity(cname,fid,aid);
    }

    @Override
    public int del(int i) {
        return cityDao.del(i);
    }

    @Override
    public List<Citys> getAllPrivce() {
        return cityDao.getAllPrivce();
    }
}
