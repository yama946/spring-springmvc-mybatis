package com.mybatis.resource.sqlsession;

import com.mybatis.resource.Configuration;
import com.mybatis.resource.io.DataSourceUtil;
import com.mybatis.resource.proxy.MapperProxy;

import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.SQLException;

public class DefaultSqlSession implements SqlSession {
    private Configuration cfg;
    private Connection connection;

    public DefaultSqlSession(Configuration cfg){
        this.cfg = cfg;
        connection = DataSourceUtil.getConnection(cfg);
    }
    /**
     * 用于创建代理对象
     * @param daoInterfaceClass
     * @param <T>
     * @return
     */
    public <T> T getMapper(Class<T> daoInterfaceClass) {
        return (T)Proxy.newProxyInstance(daoInterfaceClass.getClassLoader(),new Class[]{daoInterfaceClass}, new MapperProxy(cfg.getMapper(),connection));
    }

    /**
     * 用于是释放资源
     */
    public void close() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
