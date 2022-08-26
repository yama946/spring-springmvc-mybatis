package com.yama.dao;

import com.yama.domain.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * 当表中列名和类中属性名不匹配时，导致无法封装的解决方式
 *      （1）第一种方式，和xml中相同，直接在查询语句中直接使用别名
 *      (2)第二种方式，使用注解标识，和xml标签名以及使用类似，
 *          在xml中使用resultMap标签，其中id标识主键别名配置，result标识非主键配置，并为resultMap设置id属性便于其他引用
 *          在注解中使用results进行配置，其中id指定唯一标识便于使用注解resultMap进行引用，使用value属性配置映射关系。
 */
@CacheNamespace(blocking = true)
public interface UserMapper {
    /**
     * 查询所有操作,此时findAll可以查询到每个用户，与账户信息，因为时一对多的关系，所以采取懒加载模式
     * @return
     */
    @Select("select * from user;")
    @Results(id = "nickNameMapper",value = {
            //当id为true，标识配置主键，id默认值为false
            @Result(id=true,property = "userid",column = "id"),
            //非主键映射配置
            @Result(property = "username",column = "username"),
            @Result(property = "userbirthday",column = "birthday"),
            @Result(property = "usersex",column = "sex"),
            @Result(property = "useraddress",column = "address"),
            @Result(property = "accounts",column = "id",many= @Many(select = "com.yama.dao.AccountMapper.findById",fetchType = FetchType.LAZY))
    })
    List<User> findAll();

    /**
     * 查询一个
     * @param id
     * @return
     */
    @Select("select * from user where id = #{userid};")
    @ResultMap(value = {"nickNameMapper"})
    User findById(Integer id);
}
