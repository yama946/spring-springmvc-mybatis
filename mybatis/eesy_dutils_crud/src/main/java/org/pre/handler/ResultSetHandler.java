package org.pre.handler;

import java.sql.ResultSet;

/**
 * 结果集封装的接口
 * @param <T>
 */
public interface ResultSetHandler<T> {
    /**
     * 结果集封装的方法
     * @param res
     * @return
     */
    T handler(ResultSet res);
}
