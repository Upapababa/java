package com.sz.zhiling.service;

public interface IUP {

    public int add(String crno, String crname, String craddr, String capacity);

    public int upd(String crid, String crno, String crname, String craddr, String capacity);

    public int del(String crid);
}
