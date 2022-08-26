package com.mybatis.crud.dao;

import com.mybatis.crud.pojo.Role;
import com.mybatis.crud.pojo.User;

import java.util.List;

public interface RoleMapper {
    /**
     * 查询所有角色并获取角色对应用户信息
     */
    List<Role> findAll();
}
