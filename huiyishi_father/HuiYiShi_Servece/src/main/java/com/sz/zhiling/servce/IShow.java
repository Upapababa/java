package com.sz.zhiling.servce;

import com.sz.zhiling.modle.Conferenceroom;

import java.util.List;

public interface IShow {
    public List<Conferenceroom> showAll(int page);
    public int showAllpage();
}
