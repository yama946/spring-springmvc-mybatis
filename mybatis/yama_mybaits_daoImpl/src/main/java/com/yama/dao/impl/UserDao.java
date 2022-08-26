package com.yama.dao.impl;

import com.yama.dao.UserMapper;
import com.yama.domain.User;

import java.sql.*;
import java.util.List;

/**
 * 传统的JDBC的方式
 */
public class UserDao implements UserMapper {
    public List<User> findAll() {
        try {
            //1、加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            //注册驱动的方式
//            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            //2、获取连接
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mybatis", "root", "yanruyi");
            //定义sql语句，其中？表示占位符
            String sql = "select * from user where username = ?";
            //获取sql语句的预处理对象
            PreparedStatement statment = conn.prepareStatement(sql);
            //为预处理对象进行设置参数，其参数的索引为从1开始
            statment.setString(1,"王五");
            //向数据库发送预处理的sql对象，也就是执行预处理对象，获取结果集
            ResultSet resultSet = statment.executeQuery();
            while(resultSet.next()){
                //此时获取到的数据集类似于一个存放键值的容器，可以通过指定键来获取值
                User u = new User();
                u.setId(resultSet.getInt("id"));
                u.setUsername(resultSet.getString("username"));
                u.setSex(resultSet.getString("sex"));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
