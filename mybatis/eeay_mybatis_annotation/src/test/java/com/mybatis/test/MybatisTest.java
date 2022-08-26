package com.mybatis.test;

import com.mybatis.dao.IDaoMapper;
import com.mybatis.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MybatisTest {
    /**
     * 获取配置文件
     * 创建sqlsessionfactory对象
     * 获取sqlsession对象
     * 通过sqlsession对象获取代理对象
     * 通过代理对象调用方法
     * 释放资源
     */
    public static void main(String[] args) throws IOException {
        InputStream in = Resources.getResourceAsStream("SqlMapperConfig.xml");
        SqlSessionFactoryBuilder builders = new SqlSessionFactoryBuilder();
        SqlSessionFactory build = builders.build(in);
        SqlSession session = build.openSession();
        IDaoMapper map = session.getMapper(IDaoMapper.class);
        List<User> users = map.findAll();
        for (User u:
             users) {
            System.out.println(u);
        }
        session.close();
        in.close();
    }
}
