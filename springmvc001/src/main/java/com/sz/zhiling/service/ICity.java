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

    public int updpname(String pname,String aid);

    public int updCity(String cname, int fid, String aid);

    public int del(int i);

    public List<Citys> getAllPrivce();
}
