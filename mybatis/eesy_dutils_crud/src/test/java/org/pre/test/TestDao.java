package org.pre.test;

import org.pre.dao.AccountDao;
import org.pre.dao.impl.AccountDaoImpl;
import org.pre.pojo.Account;

public class TestDao {
    public static void main(String[] args) {
        AccountDao accountDao = new AccountDaoImpl();
        Account account = new Account();
        account.setName("hello");
        account.setMoney(12345f);
        accountDao.save(account);
    }
}
