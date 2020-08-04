package com.sz.zhiling.JDBC;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class MyUtil {

    //工具类
    private static ComboPooledDataSource dataSource = new ComboPooledDataSource();

    public static ComboPooledDataSource getDataSource(){
        return dataSource;
    }

}
