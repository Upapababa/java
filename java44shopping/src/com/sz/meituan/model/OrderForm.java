package com.sz.meituan.model;

public class OrderForm {
//    fname,fprice,num,xiaoji
        private String fname;
        private float fprice;
        private int num;
        private float xiaoji;

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public float getFprice() {
        return fprice;
    }

    public void setFprice(float fprice) {
        this.fprice = fprice;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public float getXiaoji() {
        return xiaoji;
    }

    public void setXiaoji(float xiaoji) {
        this.xiaoji = xiaoji;
    }

    public OrderForm() {
    }

    public OrderForm(String fname, float fprice, int num, float xiaoji) {
        this.fname = fname;
        this.fprice = fprice;
        this.num = num;
        this.xiaoji = xiaoji;
    }
}
