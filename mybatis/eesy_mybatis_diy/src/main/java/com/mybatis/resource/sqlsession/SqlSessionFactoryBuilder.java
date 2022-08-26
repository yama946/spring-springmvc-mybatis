package com.mybatis.resource.sqlsession;

import com.mybatis.resource.Configuration;
import com.mybatis.resource.util.XMLConfigBuilder;

import java.io.InputStream;

public class SqlSessionFactoryBuilder {
    /**
     * 根据参数的字节输入流来构建一个SqlSessionFactory工厂
     * 通过获取配置文件，
     * @param config
     * @return
     */
    public SqlSessionFactory build(InputStream config){
        Configuration cfg = XMLConfigBuilder.loadConfiguration(config);
            return new DefaultSqlSessionFactory(cfg);
    }
}
