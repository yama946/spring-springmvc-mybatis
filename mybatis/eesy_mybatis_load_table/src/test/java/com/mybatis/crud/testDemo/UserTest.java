package com.mybatis.crud.testDemo;

import com.mybatis.crud.dao.UserMapper;
import com.mybatis.crud.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserTest {
    InputStream resources;
    SqlSession sqlSession;
    UserMapper mapper;

    @Before//在开始时启动
    public void init() throws IOException {
        //        读取配置文件，生成输入字节流
        resources = Resources.getResourceAsStream("SqlMapperConfig.xml");
//        通过构建模式生成一个工厂对象
        SqlSessionFactoryBuilder builds = new SqlSessionFactoryBuilder();
        SqlSessionFactory build = builds.build(resources);
//        通过工厂对象生成一个连接对象并生成代理对象
        sqlSession = build.openSession(true);//当opensession中的参数为true时，此时的事务为自动提交。
        mapper = sqlSession.getMapper(UserMapper.class);
    }

    @After
    public void destory() throws IOException {
//      通过连接对象来进行提交事务
        sqlSession.commit();
        //        释放资源
        sqlSession.close();
        resources.close();
    }
    //    查询所有操作
    @Test
    public void testFindAll() throws IOException {
//        通过代理对象进行调用方法
        List<User> list = mapper.findAll();
        for (User all :
                list) {
            System.out.println(all);
            System.out.println(all.getAccounts());
        }
    }



}