package com.mybatis.crud.dao;

import com.mybatis.crud.pojo.Account;
import com.mybatis.crud.pojo.AccountUser;

import java.util.List;

public interface AccountMapper {

    /**
     * 进行单表查询操作，查询所用账户
     * @return
     */
    List<Account> findAll();

    /**
     * 获得所用账户的用户名
     * @return
     */
    List<AccountUser> findAllAccount();
}
