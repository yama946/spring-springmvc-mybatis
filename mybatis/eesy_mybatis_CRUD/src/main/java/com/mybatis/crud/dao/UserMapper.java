package com.mybatis.crud.dao;


import com.mybatis.crud.pojo.QueryVo;
import com.mybatis.crud.pojo.User;

import java.util.List;

/**
*
*@autor yama946
*@company www.baidu.com
*/
public interface UserMapper {
    /**
     * 查询所有操作
     */
    List<User> findAll();
    /**
     * 保存用户操作
     * @param user
     */
    void saveUser(User user);

    /**
     * 更新用户操作
     * @param user
     */
    void updateUser(User user);

    /**
     * 根据id删除用户
     * @param id
     */
    void deleteUser(int id);

    /**
     * 根据用户id，进行查询信息
     * @param id
     * @return
     */
    User findById(int id);

    /**
     * 通过模糊查询相应用户信息
     * @param username
     * @return
     */
    List<User> findByName(String username);

    /**
     *通过使用聚合函数进行统计总记录条数
     * @return
     */
    int findTotal();
    /**
     * ognl表达式的使用，当参数中不仅仅使用用用户信息时
     * @param
     */
    List<User> findByqueryVo(QueryVo username);

    /**
     * 通过条件来进行查询
     * @param user
     * @return
     */
    List<User> findByCondition(User user);
    /**
     * 当使用in进行查询时，会使用到foreach来进行遍历
     * @param vo
     * @return User
     */
    List<User> findByIds(QueryVo vo);
}
