package com.mybatis.crud.dao;


import com.mybatis.crud.pojo.User;

import java.util.List;

/**
*
*@autor yama946
*@company www.baidu.com
*/
public interface UserMapper {
    /**
     * 查询所有用户操作并获得用户的账户信息
     */
    List<User> findAll();

    /**
     * 根据用户id，进行查询信
     * @return
     */
    List<User> findById();


}
