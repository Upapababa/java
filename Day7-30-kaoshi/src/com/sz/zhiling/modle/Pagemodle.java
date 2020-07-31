package com.sz.zhiling.modle;

import java.util.List;

public class Pagemodle {
    private int page;
    private int count;
    private List<Conferenceroom> list;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<Conferenceroom> getList() {
        return list;
    }

    public void setList(List<Conferenceroom> list) {
        this.list = list;
    }

    public Pagemodle() {
    }

    public Pagemodle(int page, int count, List<Conferenceroom> list) {
        this.page = page;
        this.count = count;
        this.list = list;
    }
}
