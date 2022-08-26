package com.yama.mybatis.annotation;

import java.lang.annotation.*;

/**
*
*@autor yama946
*@company www.baidu.com
 *查询的注解
*/
@Target(ElementType.METHOD)//作用位置方法或者类
@Retention(RetentionPolicy.RUNTIME)
@Documented//定义此注解是否会被抽取到api中
@Inherited//定义此注解是否被继承
public @interface Select {
    /**
     * 定义标识，其属性值为sql语句
     * @return
     */
    String name();
}
