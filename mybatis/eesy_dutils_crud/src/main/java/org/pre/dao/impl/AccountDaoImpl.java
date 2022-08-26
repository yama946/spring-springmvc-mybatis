package org.pre.dao.impl;

import org.pre.dao.AccountDao;
import org.pre.dbassit.DBAssit;
import org.pre.pojo.Account;
import org.pre.utils.C3P0Util;

import java.util.List;

public class AccountDaoImpl  implements AccountDao {
    private DBAssit dbAssit = new DBAssit(C3P0Util.getDataSource());

    public void save(Account account) {
            dbAssit.update("insert into account(name,money) values(?,?)",account.getName(),account.getMoney());
    }

    public void update(Account account) {

    }

    public void delete(Integer id) {

    }

    public Account findById(Integer id) {
        return null;
    }

    public List<Account> findAll() {
        return null;
    }
}
