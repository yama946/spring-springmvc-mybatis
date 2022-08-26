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
     * 演示ognl表达式的使用，主要是查询条件不直接是属性的映射配置文件中参数书写
     * @param vo
     * @return
     */
    List<User> queryVo(QueryVo vo);

    /**
     * 根据传入参数条件，进行查找
     * @param user 查询条件中：可能存在用户名，可能存在性别，也可能存在地址，还可能都有
     *             因此需要进行判断，if
     *             对于where 1=1的理解，1=1相当于true此时的所有字段都将满足
     * @return
     */
    List<User> findUserByCondition(User user);

    /**
     * 根据queryvo中的id集合进行查询
     * @param vo
     * @return
     */
    List<User> findUserInIds(QueryVo vo);
}
