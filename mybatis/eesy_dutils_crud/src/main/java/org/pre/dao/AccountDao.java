package org.pre.dao;

import org.pre.pojo.Account;

import java.util.List;

/**
 *  账户的持久层接口
 */
public interface AccountDao {
    /**
     * 保存操作
     * @param account
     */
    void save(Account account);

    /**
     *更新操作
     * @param account
     */
    void update(Account account);

    /**
     * 删除操作
     * @param id
     */
    void delete(Integer id);

    /**
     * 通过id进行查询
     * @param id
     * @return
     */
    Account findById(Integer id);

    /**
     * 查询所有操作
     * @return
     */
    List<Account> findAll();
}
