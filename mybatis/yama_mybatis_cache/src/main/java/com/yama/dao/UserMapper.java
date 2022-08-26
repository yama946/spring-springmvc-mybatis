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
     * 更新用户，用来测试缓存是否会清除，实现查询的同步的
     */
    void updateUser(User user);
}
