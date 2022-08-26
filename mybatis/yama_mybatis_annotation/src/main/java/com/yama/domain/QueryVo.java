package com.yama.domain;

import com.yama.domain.User;

/**
 * 当传入的参数值不再是直接的pojo，而是其中包含了一个pojo对象
 * 此时映射配置文件的参数怎么写，这是这个类的表达的目的
 * 也是ognl表达式的使用，对象图导航语言
 */
public class QueryVo {
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
