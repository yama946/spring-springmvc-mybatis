package com.yama.service;

import com.yama.domain.Account;

import java.util.List;

/**
 * 账户的业务层接口，
 * 连接点；接口中所有的方法都是连接点，因为都可以被代理拦截
 * 切入点：接口中的方法代理拦截，并进行方法增强，通常是增加事务管理的点
 * 通知：切入点方法执行前后，要做的事，执行的方法，一般是invoke前后的语句。
 * 织入：对代理对象进行增强方法，返回代理对象的过程叫做织入
 * 切面：切入点和通知结合的过程，配置切面，就是通过配置的方式让切入点和通知结合起来。
 * 这里我们使用代理实现的，切面这里可以说是将TransactionManager中的方法与业务层方法结合起来
 *
 */
public interface IAccountService {

    /**
     * 查询所有
     * @return
     */
    List<Account> findAllAccount();

    /**
     * 查询一个
     * @return
     */
    Account findAccountById(Integer accountId);

    /**
     * 保存
     * @param account
     */
    void saveAccount(Account account);

    /**
     * 更新
     * @param account
     */
    void updateAccount(Account account);

    /**
     * 删除
     * @param acccountId
     */
    void deleteAccount(Integer acccountId);

    /**
     * 转账
     * @param sourceName        转出账户名称
     * @param targetName        转入账户名称
     * @param money             转账金额
     */
    void transfer(String sourceName,String targetName,Float money);

    //void test();//它只是连接点，但不是切入点，因为没有被增强
}
