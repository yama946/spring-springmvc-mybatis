package com.yama.mybatis.session;
/**
*
*@autor yama946
*@company www.baidu.com
 *自定义mybatis中与数据库交互的核心类
 * 可以生产出dao接口的代理对象
*/
public interface SqlSession {
    /**
     * 通过传入一个字节码对象，生产出一个代理对象
     * @param daoInterfaceClass
     * @param <T>
     * @return
     */
    public <T> T getMapper(Class<T> daoInterfaceClass);

    /**
     * 关闭流
     */
    public void close();
}
