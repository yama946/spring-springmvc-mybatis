package com.yama.test;

import com.yama.dao.UserMapper;
import com.yama.dao.impl.UserMapperImpl;
import com.yama.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestDo {
    public static void main(String[] args) {

        try {
            //加载主配置文件获取流文件
            InputStream resource = Resources.getResourceAsStream("SqlConfig.xml");
            /**
             *这里获取配置文件的方式有，绝对路径或者相对路径，但是通常不用因为，在项目部署后都将会路径都会变化
             * 可以使用类加载器，:只能读取类路径下的配置文件
             * 使用ServletContext的getpath获取：路径有项目进行动态变化
             */
            //获取工厂
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();//构建者模式
            SqlSessionFactory sqlSessionFactory = builder.build(resource);//工厂模式
            //通过工厂获取sqlsession对象
            UserMapperImpl mapper = new UserMapperImpl(sqlSessionFactory);
            List<User> users = mapper.findAll();
//            UserMapper mapper = sqlSession.getMapper(UserMapper.class);//代理模式
//            List<User> users = mapper.findAll();
            for (User u : users) {
                System.out.println(u);
            }
            resource.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
