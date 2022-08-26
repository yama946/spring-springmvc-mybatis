package com.mybatis.crud.testDemo;

import com.mybatis.crud.dao.UserMapper;
import com.mybatis.crud.pojo.QueryVo;
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

public class MybatisDemo {
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
        }
    }

    /**
     * 测试保存用户方法
     */
    @Test
    public void testSaveUsers() {
        User u  = new User();
        u.setUsername("宋江");
        u.setBirthday(new Date());
        u.setSex("男");
        u.setAddress("梁山");
        System.out.println(u);
        //执行保存操作
        mapper.saveUser(u);

    }

    /**
     * 测试更新操作
     */
    @Test
    public void testUpdateUser() {
        User u  = new User();
        u.setId(41);
        u.setUsername("林冲");
        u.setBirthday(new Date());
        u.setSex("男");
        u.setAddress("汴京");
        //执行更新操作
        mapper.updateUser(u);
    }

    /**
     * 根据提供的id进行删除用户
     */
    @Test
    public void testDeleteUser() {
        mapper.deleteUser(41);
    }

    /**
     * 根据id进行查询指定用户。
     */
    @Test
    public void testFindById() {
        User u= new User();
        u=mapper.findById(54);
        System.out.println("查询到的用户如下:");
        System.out.println(u);
    }

    /**
     * 根据用户名称进行模糊查询
     */
    @Test
    public void testFindByName() {
        List<User> user =  mapper.findByName("%王%");
        for(User u:user){
            System.out.println(
                    u
            );
        }
    }
    /**
     * 通过使用聚合函数进行统计用户数
     */
    @Test
    public void testFindTotal(){
        System.out.println("用户的个数为："+mapper.findTotal());
    }
    /**
     * 根据用户名称进行模糊查询
     */
    @Test
    public void testfindByqueryVo() {
        QueryVo vo = new QueryVo();
        User name = new User();
        name.setUsername("%王%");
        vo.setU(name);
        List<User> user =  mapper.findByqueryVo(vo);
        for(User u:user){
            System.out.println(
                    u
            );
        }
    }

    @Test
    public void testFindByCondition(){
        User u = new User();
        u.setUsername("林冲");
        List<User> user = mapper.findByCondition(u);
        for (User u1:
            user) {
            System.out.println(u1);
        }
    }
    @Test
    public void testFindIds(){
        QueryVo vo  = new QueryVo();
        List<Integer> list  = new ArrayList<Integer>();
        list.add(42);
        list.add(43);
        list.add(44);
        vo.setIds(list);
        List<User> user = mapper.findByIds(vo);
        for (User u1:
                user) {
            System.out.println(u1);
        }
    }
}