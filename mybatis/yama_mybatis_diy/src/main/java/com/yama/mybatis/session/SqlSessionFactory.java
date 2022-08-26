package com.yama.mybatis.session;
/**
*
*@autor yama946
*@company www.baidu.com
 *
*/
public interface SqlSessionFactory {
    /**
     * 使用工厂模式，生产出一个sqlsession对象
     * @return
     */
    public SqlSession openSession();

}
