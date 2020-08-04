package com.sz.zhiling.servce;

import com.sz.zhiling.dao.ShowDao;
import com.sz.zhiling.modle.Conferenceroom;

import java.util.List;

public class IShowImp implements IShow {

    ShowDao sd=new ShowDao();

    @Override
    public List<Conferenceroom> showAll(int page) {
        return  sd.showAll(page);
    }

    @Override
    public int showAllpage() {
        return sd.showAllpage();
    }
}
