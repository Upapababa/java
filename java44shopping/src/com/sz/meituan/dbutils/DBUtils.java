package com.sz.meituan.dbutils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;

public class DBUtils {
    //工具类；
    private static ComboPooledDataSource dataSource = new ComboPooledDataSource();


    public static DataSource getDataSource(){
        return dataSource;
    }


}
