package com.yama.mybatis.session.defaults;

import com.yama.mybatis.cfg.Configuration;
import com.yama.mybatis.session.SqlSession;
import com.yama.mybatis.session.SqlSessionFactory;

/**
*
*@autor yama946
*@company www.baidu.com
 *SqlSessionFactory工厂的实现类
*/
public class DefaultSqlSessionFactory implements SqlSessionFactory {
    private Configuration cfg;

    public DefaultSqlSessionFactory(Configuration cfg){
        this.cfg = cfg;
    }
    /**
     * 用于创建一个新的数据库操作对象，
     * 主要用来获取一个数据库连接，通过获取configuartion中的配置信息
     * 使用配置信息生产出连接
     * @return
     */
    public SqlSession openSession() {
        return new DefaultSqlSession(cfg);
    }
}
