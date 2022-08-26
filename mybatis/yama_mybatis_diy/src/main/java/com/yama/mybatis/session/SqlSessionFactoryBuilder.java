package com.yama.mybatis.session;

import com.yama.mybatis.cfg.Configuration;
import com.yama.mybatis.session.defaults.DefaultSqlSessionFactory;
import com.yama.mybatis.utils.XMLConfigBuilder;
import java.io.InputStream;

/**
*
*@autor yama946
*@company www.baidu.com
 *使用构建者模式创建一个工厂对象SqlSessionFactory
*/
public class SqlSessionFactoryBuilder {
    /**
     * 构建者模式创建对象
     * 1、通过传入的输入流（配置文件），进行解析获取相应信息
     * @param inputStream
     * @return
     */
    public SqlSessionFactory build(InputStream inputStream){
        Configuration cfg = XMLConfigBuilder.loadConfiguration(inputStream);
        return new DefaultSqlSessionFactory(cfg);
    }
}
