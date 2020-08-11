package com.sz.zhiling.module;

import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class ResoultPage {
    private int page;
    private int count;
    private List list;

    public ResoultPage() {
    }

    public ResoultPage(int page, int count, List list) {
        this.page = page;
        this.count = count;
        this.list = list;
    }

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

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "ResoultPage{" +
                "page=" + page +
                ", count=" + count +
                ", list=" + list +
                '}';
    }
}
