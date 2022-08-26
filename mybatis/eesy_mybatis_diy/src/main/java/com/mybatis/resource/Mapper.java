package com.mybatis.resource;

/**
 * 用于封装执行的sql语句和结果类型的全限定类名
 */
public class Mapper {
    private String queryString;//sql
    private String resultType;//实体类的全限定类名

    public String getQueryString() {
        return queryString;
    }

    public String getResultType() {
        return resultType;
    }

    public void setQueryString(String queryString) {
    }

    public void setResultType(String resultType) {
    }
}
