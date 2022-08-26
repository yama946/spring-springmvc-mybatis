package com.yama.mybatis.cfg;

import java.util.HashMap;
import java.util.Map;

/**
*
*@autor yama946
*@company www.baidu.com
 *自定义mybatis配置类
 * 通过读取配置文件，将配置文件中所有的连接信息提取封装到此对象中
*/
public class Configuration {
    private String driver;
    private String url;
    private String username;
    private String password;
    private Map<String,Mapper> mappers=new HashMap<String, Mapper>();

    public Map<String, Mapper> getMappers() {
        return mappers;
    }

    /**
     * 此配置表示，配置文件中mapper标签可以有多个，指向多个配置文件
     * 并且主配置文件中可以存在xml配置与注解同时存在。
     * @param mappers
     */
    public void setMappers(Map<String, Mapper> mappers) {
        this.mappers.putAll(mappers);
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
