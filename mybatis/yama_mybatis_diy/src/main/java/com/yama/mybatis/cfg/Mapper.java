package com.yama.mybatis.cfg;
/**
*
*@autor yama946
*@company www.baidu.com
 *用于封装执行的sql语句和结果类型的全限定类名
*/
public class Mapper {
    private String queryString;//sql
    private String resultType;//结果类的全限定类名

    public String getQueryString() {
        return queryString;
    }

    public void setQueryString(String queryString) {
        this.queryString = queryString;
    }

    public String getResultType() {
        return resultType;
    }

    public void setResultType(String resultType) {
        this.resultType = resultType;
    }
}
