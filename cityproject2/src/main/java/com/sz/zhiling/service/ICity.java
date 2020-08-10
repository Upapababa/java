package com.sz.zhiling.service;

import com.sz.zhiling.module.Citys;

import java.util.List;

public interface ICity {

    public List<Citys> showAllCity(int page);

    public int showAllPage();

    public String showCityName(int fid);

    public int addPname(String pname);

    public int showAid(String pname);

    public int addCname(String cname, int aid);
}
