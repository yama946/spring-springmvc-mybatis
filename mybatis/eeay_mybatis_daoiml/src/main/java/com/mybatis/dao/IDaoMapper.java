package com.mybatis.dao;

import com.mybatis.pojo.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IDaoMapper {
    //创建接口
    @Select("select * from user")
    List<User> findAll();
}
