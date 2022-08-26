package com.mybatis.crud.dao;

import com.mybatis.crud.pojo.Account;

import java.util.List;

public interface AccountMapper {

    /**
     * 进行单表查询操作，查询所用账户
     * @return
     */
    List<Account> findAll();

    List<Account> findById();

}
