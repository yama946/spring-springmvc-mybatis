package com.yama.dao;

import com.yama.domain.User;

import java.util.List;

public interface UserMapper {
    List<User> findAll();
}
