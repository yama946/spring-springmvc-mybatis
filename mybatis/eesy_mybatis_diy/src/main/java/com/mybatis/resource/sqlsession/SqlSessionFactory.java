package com.mybatis.resource.sqlsession;
/**
 * 用于打开一个新的SqlSession对象
 * @return
 */
public interface SqlSessionFactory {
    SqlSession openSession();
}
