package com.yama.dao;

import com.yama.domain.User;

import java.util.List;

public interface UserMapper {
    /**
     * 查询所有操作
     * @return
     */
    List<User> findAll();

    /**
     * 查询一个
     * @param id
     * @return
     */
    User findById(Integer id);

    /**
     * 查询所用用户以及相关的账户信息
     * @return
     */
    List<User> findAllUserAccount();

    /**
     * 懒加载，一对多，进行设置collection标签，何设置查询所有语句，通过查询的语句进行再次
     * @return
     */
    List<User> userLazyLoad();
}
