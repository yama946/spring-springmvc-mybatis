package com.mybatis.resource.sqlsession;

import com.mybatis.resource.Configuration;

public class DefaultSqlSessionFactory implements SqlSessionFactory {
    private Configuration cfg;
    public DefaultSqlSessionFactory(Configuration cfg) {
            this.cfg = cfg;
    }
    /**
     * 用于创建一个新的数据库连接对象
     * @return
     */
    public SqlSession openSession() {
        return new DefaultSqlSession(cfg);
    }
}
