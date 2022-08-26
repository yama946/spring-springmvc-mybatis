package com.yama.dao;

import com.yama.domain.QueryVo;
import com.yama.domain.User;

import java.util.List;

public interface UserMapper {
    /**
     * 查询所有操作
     * @return
     */
    List<User> findAll();

    /**
     * 保存用户操作
     * @param user
     */
    void saveUser(User user);

    /**
     * 修改用户，
     * @param user
     */
    void updateUser(User user);

    /**
     * 删除用户
     * @param id
     */
    void deleteById(Integer id);

    /**
     * 查询一个
     * @param id
     * @return
     */
    User findById(Integer id);

    /**
     * 模糊查询
     * @return
     */
    List<User> findByName(String username);
    /**
     * CRUD中也支持使用聚合函数进行一行列的查询方式
     * 查询表中总数
     */
    int findCount();

    /**
     * 演示ognl表达式的使用，主要是查询条件不直接是属性的映射配置文件中参数书写
     * @param vo
     * @return
     */
    List<User> queryVo(QueryVo vo);
}
