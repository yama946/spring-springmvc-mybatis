package com.yama.domain;

import java.util.List;

/**
 * 当传入的参数值不再是直接的pojo，而是其中包含了一个pojo对象
 * 此时映射配置文件的参数怎么写，这是这个类的表达的目的
 * 也是ognl表达式的使用，对象图导航语言
 */
public class QueryVo {
    private User user;

    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }

    /**
     * 在SQL中我们常存在这样的语句：select * from user where id(15,23,46);
     * 为了在mybatis中实现这种语句的查询，使用foreach标签，同时在对象中定义一个集合属性，来保存这些值用查询
     */
    private List<Integer> ids;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
