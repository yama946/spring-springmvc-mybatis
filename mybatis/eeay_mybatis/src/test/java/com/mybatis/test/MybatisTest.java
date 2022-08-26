package com.mybatis.test;

import com.mybatis.dao.IUserMapper;
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
//          第三步：使用工厂生产一个SqlSession对象
        SqlSession session = factroy.openSession();
//          第四步：使用SqlSession创建Dao接口的代理对象
        IUserMapper usermapper = session.getMapper(IUserMapper.class);
//          第五步：使用代理对象执行方法
        List<User> users = usermapper.findAll();
        for (User u:users){
            System.out.println(u);
        }
        //释放资源
        session.close();
        in.close();
    }

}
