package com.yama.test;

import com.yama.dao.AccountMapper;
import com.yama.dao.UserMapper;
import com.yama.domain.Account;
import com.yama.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

/**
*@autor yama946
*@company www.baidu.com
 *CRUD测试方法
*/
public class AccountTest {
    InputStream resource;
    SqlSession sqlSession;
    AccountMapper mapper;

    @Before//此注解定义在测试包中，指定此方法需要在测试方法执行前执行
    public void init(){
        try {
            //加载主配置文件获取流文件
            resource = Resources.getResourceAsStream("SqlConfig.xml");
            //获取工厂
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();//构建者模式
            SqlSessionFactory sqlSessionFactory = builder.build(resource);//工厂模式
            //通过工厂获取sqlsession对象
            //在使用sqlSessionFactory.openSession()可以在方法中添加参数来开启自动提交事务openSession(true)
            sqlSession = sqlSessionFactory.openSession();
            mapper = sqlSession.getMapper(AccountMapper.class);//代理模式
            //仅仅为usermaper代理，对于其他的接口类还需要进行创建代理对象
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @After//此注解定义在测试包中，指定此方法在测试方法执行后执行
    public void destory(){
        try {
            //提交事务
            sqlSession.commit();
            //释放资源
            sqlSession.close();
            resource.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 在使用注解的情况下，表与表之间的关联查询
     */
    @Test
    public void testFindAll(){
        List<Account> accounts = mapper.findAll();
        for (Account a:accounts){
            System.out.println(a);
            System.out.println(a.getUser());
        }
    }

    /**
     * 在使用注解的情况下，表与表之间的关联查询
     */
    @Test
    public void testFindAccountByUser(){
        List<Account> accounts = mapper.findAccountByUser();
        for (Account a:accounts){
            System.out.println(a);
            System.out.println(a.getUser());
        }
    }
}
