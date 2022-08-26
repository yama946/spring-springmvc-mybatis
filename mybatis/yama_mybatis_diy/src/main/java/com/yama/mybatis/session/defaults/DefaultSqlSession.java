package com.yama.mybatis.session.defaults;

import com.yama.mybatis.cfg.Configuration;
import com.yama.mybatis.session.SqlSession;
import com.yama.mybatis.session.proxy.MapperProxy;
import com.yama.mybatis.utils.DataSourceUtil;
import java.lang.reflect.Proxy;
import java.sql.Connection;


/**
*
*@autor yama946
*@company www.baidu.com
 *sqlsession的实现类
*/
public class DefaultSqlSession implements SqlSession {
    private Configuration cfg;
    private Connection connection;

    public DefaultSqlSession(Configuration cfg){
        this.cfg = cfg;
        this.connection = DataSourceUtil.getConnection(cfg);
    }
    /**
     * 用于创建代理对象,
     * 将配置文件传递当此，因为生产代理对象，当代理对象调用方法时，
     * 对方法进行增强，将连接，传递参数都可以在增强方法中实现
     * @param daoInterfaceClass
     * @param <T>
     * @return
     */
    public <T> T getMapper(Class<T> daoInterfaceClass) {
        return (T)Proxy.newProxyInstance(daoInterfaceClass.getClassLoader(),
                new Class[]{daoInterfaceClass}, new MapperProxy(cfg.getMappers(),connection));
    }

    /**
     * 用于释放资源
     */
    public void close() {
        if (connection != null) {
            try {
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
