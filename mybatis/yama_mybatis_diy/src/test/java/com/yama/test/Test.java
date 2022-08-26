package com.yama.test;

import com.yama.dao.UserMapper;
import com.yama.domain.User;
import com.yama.mybatis.io.Resources;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import com.yama.mybatis.session.SqlSession;
import com.yama.mybatis.session.SqlSessionFactory;
import com.yama.mybatis.session.SqlSessionFactoryBuilder;


public class Test {
    /**
     * 自定义mybatis中涉及到的类
     *      class Resources
     *      class SqlSessionFactoryBuilder
     *      interface SqlSessionFactory
     *      interface SqlSession
     * @param args
     */
    public static void main(String[] args) {

        try {
            //加载主配置文件获取流文件
            InputStream resource = Resources.getResourceAsStream("SqlConfig.xml");
            //获取工厂
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();//构建者模式
            SqlSessionFactory sqlSessionFactory = builder.build(resource);//工厂模式
            //通过工厂获取sqlsession对象
            SqlSession sqlSession = sqlSessionFactory.openSession();
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);//代理模式
            List<User> users = mapper.findAll();
            for (User u:users){
                System.out.println(u);
            }
            //释放资源
            sqlSession.close();
            resource.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
