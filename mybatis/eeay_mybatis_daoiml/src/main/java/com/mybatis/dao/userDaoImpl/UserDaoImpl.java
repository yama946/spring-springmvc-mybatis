package com.mybatis.dao.userDaoImpl;

import com.mybatis.dao.IDaoMapper;
import com.mybatis.pojo.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class UserDaoImpl implements IDaoMapper {
    SqlSessionFactory factory=null;

    public UserDaoImpl(SqlSessionFactory factory){
        this.factory=factory;
    }

    public List<User> findAll() {
        SqlSession session = factory.openSession();
        List<User> users = session.selectList("com.mybatis.dao.IDaoMapper.findAll");
        session.close();
        return users;
    }
}
