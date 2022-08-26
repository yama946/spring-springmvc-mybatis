package com.yama.dao;

import com.yama.domain.Account;
import com.yama.domain.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface AccountMapper {
    /**
     * 查询所有操作，在查询到一个账户的同时显示用户信息
     * @return
     */
    @Select("select * from account;")
    List<Account> findAll();

    /**
     * 多表联查
     * @return
     */
    @Select("select * from account;")
    @Results(id = "Mapper",value = {
            //当id为true，标识配置主键，id默认值为false
            @Result(id=true,property = "id",column = "id"),
            //非主键映射配置
            @Result(property = "uid",column = "uid"),
            @Result(property = "money",column = "money"),
            @Result(property = "user",column = "uid",one=@One(select = "com.yama.dao.UserMapper.findById",fetchType= FetchType.EAGER)),
            /**
             *  在注解中链表查询时，类似于xml中定义延迟加载的配置，不是自己直接查出两个表，而是用属性去调用别的类中方法执行
             *  在Result注解中存在，一个One属性，标识一对一关系，many属性表示一对多关系
             *     （1） 其中one又对应一个@One注解，此诸结中select属性表示要调用的方法全类名，fetchType属性，
             *      其属性值是一个枚举对象，其中lazy表示懒加载，EAGER表示立即加载，在一对多关系中应该立即加载
             */
    })
    List<Account> findAccountByUser();


    /**
     * 查询一个
     * @param id
     * @return
     */
    @Select("select * from account where uid = #{uid};")
    Account findById(Integer id);
}
