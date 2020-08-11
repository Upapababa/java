package com.sz.zhiling.service;

import com.sz.zhiling.model.Conferenceroom;

import java.util.List;

public interface IShow {
    public List<Conferenceroom> showAll(int page);
    public int showAllpage();
}
