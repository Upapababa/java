package com.sz.zhiling.servce;

import com.sz.zhiling.dao.UPDao;

public class IUPimp implements IUP {
    UPDao sd=new UPDao();
    @Override
    public int add(String crno, String crname, String craddr, String capacity) {
        return sd.add(crno,crname,craddr,capacity);
    }

    @Override
    public int upd(String crid, String crno, String crname, String craddr, String capacity) {
        return sd.upd(crid,crno,crname,craddr,capacity);
    }

    @Override
    public int del(String crid) {
        return sd.del(crid);
    }
}
