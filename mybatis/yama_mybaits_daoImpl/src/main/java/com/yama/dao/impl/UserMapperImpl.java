package com.yama.dao.impl;

import com.yama.dao.UserMapper;
import com.yama.domain.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class UserMapperImpl implements UserMapper {
    private SqlSessionFactory sessionFactory;

    public UserMapperImpl(SqlSessionFactory session) {
        this.sessionFactory = session;
    }

    public List<User> findAll() {
        SqlSession session = sessionFactory.openSession();
        List<User> user = session.selectList("com.yama.dao.UserMapper.findAll");
        session.close();
        return user;
    }
}
