package com.yama.dao;

import com.yama.domain.QueryVo;
import com.yama.domain.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * 演示使用注解的mybatis，针对注解的CRUD以用有四种
 * 当mybatis在扫描文件时，同时扫描到注解或者xml则会报错，即使使用class属性限定也不行，
 * 除非xml不再要扫描的包下，因此两种配置方式不相容，当然若果其他类包也可以用xml开发。同一个接口是不能同时使用的。
 * @Select, 使用此注解mybatis会根据主配置文件扫描相应包下，是否有此注解,存在则反射出方法和类型，便于封装
 * @Insert
 * @Update
 * @Delete 以上三个需要参数的，当扫描注解也会反射到相应方法，并获得其函数形参类型，得到查询参数。
 */
public interface UserMapper {
    /**
     * 查询所有操作
     * @return
     */
    @Select("select * from user;")
    List<User> findAll();

    /**
     * 保存用户操作
     * @param user
     */
    @Insert("insert into user(username,birthday,sex,address) values(#{username},#{birthday},#{sex},#{address});")
    void saveUser(User user);

    /**
     * 修改用户，
     * @param user
     */
    @Update("update user set username = #{username},birthday=#{birthday},sex=#{sex},address =#{address} where id = #{id};")
    void updateUser(User user);

    /**
     * 删除用户
     * @param id
     */
    @Delete("delete from user where id = #{id};")
    void deleteById(Integer id);

    /**
     * 查询一个
     * @param id
     * @return
     */
    @Select("select * from user where id = #{id};")
    User findById(Integer id);

    /**
     * 模糊查询
     * @return
     */
    @Select("select * from user where username like #{username};")
    List<User> findByName(String username);
    /**
     * CRUD中也支持使用聚合函数进行一行列的查询方式
     * 查询表中总数
     */
    @Select("select count(*) from user;")
    int findCount();

    /**
     * 演示ognl表达式的使用，主要是查询条件不直接是属性的映射配置文件中参数书写
     * @param vo
     * @return
     */
    @Select("select * from user where username like #{user.username}")
    List<User> queryVo(QueryVo vo);
}
