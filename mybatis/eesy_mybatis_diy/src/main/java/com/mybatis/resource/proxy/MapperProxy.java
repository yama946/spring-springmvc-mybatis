package com.mybatis.resource.proxy;

import com.mybatis.resource.Mapper;
import com.mybatis.resource.util.Executor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.util.Map;

public class MapperProxy implements InvocationHandler {
    private Map<String, Mapper> mappers;
    private Connection conn;
    //map的key是全限定类名和方法名
    public MapperProxy(Map<String,Mapper> mappers,Connection conn){
            this.mappers = mappers;
            this.conn = conn;
    }
    /**
     * 此方法是对方法进行增强的，主要增强方式是调用selectlist方法
     * @param proxy
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //1、获取方法名
        String methodName = method.getName();
        //2、获取方法所在的类的名称
        String className = method.getDeclaringClass().getName();
        //3、组合key
        String key = className+"."+methodName;
        //4、获取mappers中的mapper对象
        Mapper mapper = mappers.get(key);
        //5、判断是否存在mapper
        if(mapper==null){
            throw new IllegalArgumentException("传入的参数有误");
        }
        //6、调用工具类执行查询所有
        return new Executor().selectList(mapper,conn);
    }
}
