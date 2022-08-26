package com.yama.mybatis.utils;

import com.yama.mybatis.cfg.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
*
*@autor yama946
*@company www.baidu.com
 *用于创建数据源的工具类，可以从中获取连接
*/
public class DataSourceUtil {
    public static Connection getConnection(Configuration cfg) {
        try {
            Class.forName(cfg.getDriver());
            return DriverManager.getConnection(cfg.getUrl(), cfg.getUsername(), cfg.getPassword());
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("获取连接失败");
        }
    }
}
