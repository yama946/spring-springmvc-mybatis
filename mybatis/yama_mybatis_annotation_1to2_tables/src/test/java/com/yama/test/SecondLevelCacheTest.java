package com.yama.test;

import com.yama.dao.UserMapper;
import com.yama.domain.User;
import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;

/**
 * 在mybatis中无论是xml配置还是，注解配置，sqlsession中的一级缓存是默认开启的，
 * 那么在注解中sqlsessionFactory中的二级缓存是如何开启的
 *          (1)在主配置文件中的setting进行开启缓存配置
 *              <settings>
 *                  <setting name="cacheEnabled" value="true"/>
 *              </settings>
 *          （2)在相应的类接口名上中添加开启二级缓存的注解
 *                      @CacheNamespace(blocking = true)
 */
public class SecondLevelCacheTest {
    InputStream resource;
    SqlSession sqlSession;
    UserMapper mapper;
    SqlSessionFactory sqlSessionFactory;

    @Before//此注解定义在测试包中，指定此方法需要在测试方法执行前执行
    public void init(){
        try {
            //加载主配置文件获取流文件
            resource = Resources.getResourceAsStream("SqlConfig.xml");
            //获取工厂
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();//构建者模式
            sqlSessionFactory = builder.build(resource);//工厂模式
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @After//此注解定义在测试包中，指定此方法在测试方法执行后执行
    public void destory(){
        try {
            resource.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 测试二级缓存
     */
    @Test
    public void testFindById(){
        SqlSession sqlSession1 = sqlSessionFactory.openSession();
        UserMapper mapper1 = sqlSession1.getMapper(UserMapper.class);
        User user1 = mapper1.findById(43);
        System.out.println(user1.hashCode());
        sqlSession1.close();//关闭sqlseesion中一级缓存

        SqlSession sqlSession2 = sqlSessionFactory.openSession();
        UserMapper mapper2 = sqlSession2.getMapper(UserMapper.class);
        User user2 = mapper2.findById(43);
        System.out.println(user2.hashCode());
        sqlSession2.close();//关闭sqlseesion一级缓存

        System.out.println(user1==user2);
    }
}
