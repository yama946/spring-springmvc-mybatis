package com.yama.dao;

import com.yama.domain.Account;

import java.util.List;

/**
 * 账户的持久层接口
 */
public interface IAccountDao {
    //保存账户
    void accountSave(Account account);
    //更新账户
     void accountUpdate(Account account);
     //删除账户
    void accountDelete(Integer id);
    //查询用户
    Account findById(Integer id);
    //查询所有用户
    List<Account> findAll();

}
