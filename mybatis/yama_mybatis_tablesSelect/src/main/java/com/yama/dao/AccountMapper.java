package com.yama.dao;

import com.yama.domain.Account;
import com.yama.domain.AccountUser;

import java.util.List;

public interface AccountMapper {
    /**
     * 查询所有操作
     * @return
     */
    List<Account> findAll();

    /**
     * 查询一个
     * @param id
     * @return
     */
    Account findById(Integer id);

    /**
     *查询所有账户名，并包含其用户名和地址信息
     * 表与表之间的关系----多对一的关系，为了方便封装数据我们首先建立一个新的类，来进行表达
     * @return
     */
    List<AccountUser> findAllAccountUser();
    /**
     *查询所有账户名，并包含其用户名和地址信息
     * 此时我们的返回类型依然设置为Account，
     * 但是我们又想让其查询账户的同时封装用户信息，
     * 因为当查询到一个账户时，会存在一个用户进行捆绑显示，
     * 所以我们要在账户中建立一个主表也就用户表中用户的引用
     * ---对于mybatis如何识别封装，我们可以借助类名和表中字段名不匹配的解决方法来解决这个问题
     * 在映射配置文件中使用resultMap标签进行指定表与封装对象的映射关系来解决问题
     * @return
     */
    List<Account> findAllAccountUser1();
}
