package com.yama.service.impl;

import com.yama.dao.IAccountDao;
import com.yama.factory.BeanFactory;
import com.yama.service.IAccountService;

/**
 * 账户的业务层实现类
 */
public class AccountServiceImpl implements IAccountService {

//    private IAccountDao accountDao = new AccountDaoImpl();//创建方式1

    private IAccountDao accountDao = (IAccountDao)BeanFactory.getBean("accountDao");//创建方式2
    /**
     * 对于创建方式1与创建方式2，很明显方式2可以进行有效解耦，降低依赖
     * 而方式1，是类需要就自己进行new创建，而方式2，是类需要但是不自己创建而是找别人要
     * 对于第二种方式的解耦，叫做控制反转，类中需要的变量，不再自己直接生产而是找别人拿
     * 这种把控制权交给别人的方式，叫做控制反转。---ioc
     * 以后这种类中需要对象，不再自己直接new可以交给ioc进行依赖注入（DI），进行解耦
     * 要使用spring首先要添加依赖，获取到开发包，进行按规则使用
     */

    private int i = 1;

    public void  saveAccount(){
//        int i = 1;
        accountDao.saveAccount();
        System.out.println(i);
        i++;
    }
}
