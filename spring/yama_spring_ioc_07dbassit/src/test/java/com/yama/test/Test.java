package com.yama.test;

import com.yama.dao.IAccountDao;
import com.yama.dao.impl.AccountDaoImpl;
import com.yama.domain.Account;

import java.util.List;

/**
 * 测试
 */
public class Test {

    public static void main(String[] args) {

//        Account account = new Account();
//        account.setName("ccc");
//        account.setMoney(1234f);
        IAccountDao accountDao = new AccountDaoImpl();
//        accountDao.save(account);
//        Account account = accountDao.findById(1);
//        System.out.println(account);
        List<Account> accounts = accountDao.findAll();
        System.out.println(accounts);
    }
}

