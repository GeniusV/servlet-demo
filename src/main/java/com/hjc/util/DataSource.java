package com.hjc.util;

import com.alibaba.druid.pool.DruidDataSource;

/**
 * Created by GeniusV on 4/3/18.
 */
public class DataSource {
    private DataSource() {

    }

    private static class HoldeClass {
        private final static DruidDataSource instance = new DruidDataSource();
    }

    public static DruidDataSource getInstance() {
        return HoldeClass.instance;
    }
}
