package com.yama.dao.impl;

import com.yama.dao.IAccountDao;
import com.yama.dbassit.DBAssit;
import com.yama.domain.Account;
import com.yama.handler.impl.BeanHandler;
import com.yama.handler.impl.BeanListHandler;
import com.yama.utils.C3P0Util;

import java.util.List;

/**
 * 账户的持久层操作
 */
public class AccountDaoImpl implements IAccountDao{

    private DBAssit dbAssit = new DBAssit(C3P0Util.getDataSource());

    public void accountSave(Account account) {
        dbAssit.update("insert into account(name,money)values(?,?)",account.getName(),account.getMoney());
    }

    public void accountUpdate(Account account) {
        dbAssit.update("update account set name=?,money=? where id=?",account.getName(),account.getMoney(),account.getId());
    }

    public void accountDelete(Integer accountId) {
        dbAssit.update("delete from account where id=?",accountId);
    }

    public Account findById(Integer accountId) {
        return (Account)dbAssit.query("select * from account where id = ?",new BeanHandler(Account.class),accountId);
    }
    public List<Account> findAll() {
        return (List<Account>)dbAssit.query("select * from account",new BeanListHandler(Account.class));
    }
}
