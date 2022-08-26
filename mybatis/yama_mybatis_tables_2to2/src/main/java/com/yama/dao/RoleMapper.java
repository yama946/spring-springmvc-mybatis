package com.yama.dao;

import com.yama.domain.Role;
import com.yama.domain.User;

import java.util.List;

/**
 * 查询角色相关喜喜的接口
 */
public interface RoleMapper {
    /**
     * 查询所有操作
     * @return
     */
    List<Role> findAll();
    /**
     * 查询所用用户以及相关的角色信息
     * @return
     */
    List<Role> findAllRoleUser();
}
