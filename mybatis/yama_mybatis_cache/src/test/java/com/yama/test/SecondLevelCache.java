package com.yama.test;

import com.yama.dao.UserMapper;
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

public class SecondLevelCache {
    InputStream resource;
//    SqlSession sqlSession;
//    UserMapper mapper;
    SqlSessionFactory sqlSessionFactory;

    @Before//此注解定义在测试包中，指定此方法需要在测试方法执行前执行
    public void init(){
        try {
            //加载主配置文件获取流文件
            resource = Resources.getResourceAsStream("SqlConfig.xml");
            //获取工厂
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();//构建者模式
            sqlSessionFactory = builder.build(resource);//工厂模式
            /*//通过工厂获取sqlsession对象
            //在使用sqlSessionFactory.openSession()可以在方法中添加参数来开启自动提交事务openSession(true)
            sqlSession = sqlSessionFactory.openSession();
            mapper = sqlSession.getMapper(UserMapper.class);//代理模式
            //仅仅为usermaper代理，对于其他的接口类还需要进行创建代理对象*/
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @After//此注解定义在测试包中，指定此方法在测试方法执行后执行
    public void destory(){
        try {
            //提交事务
//            sqlSession.commit();
            //释放资源
//            sqlSession.close();
            resource.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    /**
     * 测试一级缓存，通过使用id查询出一个用户，后多次查询比较是否时同一个对象
     * 测试后打印，根据哈希值可以判定，两次查询获取的是一个对象。并且日志中仅仅存在一次查询的。
     * 当sqlsession对象消失时，缓存也将消失，通过关闭sqlsession，再重新获取开启进行测试。
     * 也可以使用sqlsession的clearcache再不关闭的情况下清除其中缓存
     */
    @Test
    public void testSecondLevelCache(){
        /**
         * 再此处用工厂同时生产多个sqlsesion，来进行测试
         * 使用二级缓存需要进行如下配置：
         *              第一步：让Mybatis框架支持二级缓存（在SqlMapConfig.xml中配置
         *                      在主配置文件中使用setting标签，将属性cacheEnabled，设置为true
         * 				第二步：让当前的映射文件支持二级缓存（在IUserDao.xml中配置）,在配置文件中添加<cache />标签
         * 				第三步：让当前的操作支持二级缓存（在select标签中配置，添加userCache=true属性，为方法查询结果添加二级缓存）
         * 			    第三步不添加经测试也可以触发二级缓存。也就是说xml中二级缓存的配置与注解相同时作用在类上的
         * 		两次存取的对象不同，是因为在二级缓存中是以数据进行存放的而不是对象，从二级缓存中进行获得后重新进行的封装。
         */
        SqlSession sqlSession1 = sqlSessionFactory.openSession();
        UserMapper mapper1 = sqlSession1.getMapper(UserMapper.class);
        User user1 = mapper1.findById(43);
        System.out.println(user1);
        sqlSession1.close();//关闭sqlseesion

        SqlSession sqlSession2 = sqlSessionFactory.openSession();
        UserMapper mapper2 = sqlSession2.getMapper(UserMapper.class);
        User user2 = mapper2.findById(43);
        System.out.println(user2);
        sqlSession2.close();//关闭sqlseesion

        System.out.println(user1==user2);
    }
}
