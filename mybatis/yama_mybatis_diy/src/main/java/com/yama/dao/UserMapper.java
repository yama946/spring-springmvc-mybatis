package com.yama.dao;

import com.yama.domain.User;
import com.yama.mybatis.annotation.Select;

import java.util.List;

public interface UserMapper {
    /**
     * 所有
     * @return
     */
    @Select(name = "select * from user")
    List<User> findAll();
}
