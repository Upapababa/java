package com.sz.zhiling.common;

import java.util.List;

public class PageBean<T> {

    private long total; //总行数；
    private List<T> rows; //当前页面的所有数据；
    private int pageSize = 2; //每页几条数据；
    private int pageTotals = 0; //总页数；
    private int pageIndex = 1; //第几页；

    public PageBean() {
    }

    public PageBean(long total, List<T> rows, int pageSize, int pageTotals, int pageIndex) {
        this.total = total;
        this.rows = rows;
        this.pageSize = pageSize;
        this.pageTotals = pageTotals;
        this.pageIndex = pageIndex;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageTotals() {
        return pageTotals;
    }

    public void setPageTotals(int pageTotals) {
        this.pageTotals = pageTotals;
    }

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }
}
