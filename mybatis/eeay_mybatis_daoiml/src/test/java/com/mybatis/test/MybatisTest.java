package com.mybatis.test;

import com.mybatis.dao.IDaoMapper;
import com.mybatis.dao.userDaoImpl.UserDaoImpl;
import com.mybatis.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
*
*@autor yama946
*@company www.baidu.com
*/
public class MybatisTest {
    public static void main(String[] args) throws IOException, IOException {

         // mybatis入门案例
//          第一步：读取配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapperConfig.xml");
//          第二步：创建SqlSessionFactory工厂
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factroy = builder.build(in);
//          创建自己的实现对象
        UserDaoImpl userDao = new UserDaoImpl(factroy);
//          第五步：使用代理对象执行方法
        List<User> users = userDao.findAll();
        for (User u:users){
            System.out.println(u);
        }
        in.close();
    }

}
