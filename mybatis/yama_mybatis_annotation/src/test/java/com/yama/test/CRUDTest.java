package com.yama.test;

import com.yama.dao.UserMapper;
import com.yama.domain.QueryVo;
import com.yama.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

/**
*@autor yama946
*@company www.baidu.com
 *CRUD测试方法
*/
public class CRUDTest {
    InputStream resource;
    SqlSession sqlSession;
    UserMapper mapper;

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
            mapper = sqlSession.getMapper(UserMapper.class);//代理模式
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

    @Test
    public void testFindAll(){
        List<User> users = mapper.findAll();
        for (User u:users){
            System.out.println(u);
        }
    }
    @Test
    public void testSaveUser(){
            User user = new User();
            user.setUsername("梁文靖");
            user.setBirthday(new Date());
            user.setSex("男");
            user.setAddress("青云峰");
            mapper.saveUser(user);
        System.out.println("事务提交后"+user);
    }

    @Test
    public void testUpdateUser(){
        User user = new User();
        user.setId(57);
        user.setUsername("花无缺");
        user.setBirthday(new Date());
        user.setSex("男");
        user.setAddress("恶人谷");
        mapper.updateUser(user);
    }
    @Test
    public void testDeleteById(){
        mapper.deleteById(54);
    }
    @Test
    public void testFindById(){
        User user = mapper.findById(57);
        System.out.println(user);
    }
    @Test
    public void testFindByName(){
        List<User> users = mapper.findByName("%王%");
//        List<User> users = mapper.findByName("王");
        for (User u:users){
            System.out.println(u);
        }
    }

    @Test
    public void testFindCount(){
       int num =  mapper.findCount();
        System.out.println("表中总数为："+num);
    }

    @Test
    public void tesQueryVo(){
        QueryVo queryVo = new QueryVo();
        User user = new User();
        user.setUsername("%王%");
        queryVo.setUser(user);
        List<User> users = mapper.queryVo(queryVo);
        for (User u:users){
            System.out.println(u);
        }
    }
}
