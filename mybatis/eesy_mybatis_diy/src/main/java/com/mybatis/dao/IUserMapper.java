package com.mybatis.dao;

import com.mybatis.pojo.User;

import java.util.List;

/**
*
*@autor yama946
*@company www.baidu.com
*/
public interface IUserMapper {
    /**
     * 查询所有操作
     */
    List<User> findAll();
}
