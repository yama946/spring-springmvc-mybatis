package com.yama.mybatis.session.proxy;

import com.yama.mybatis.cfg.Mapper;
import com.yama.mybatis.utils.Executor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.util.Map;

public class MapperProxy implements InvocationHandler {
    //从中获取全限定类名
    private Map<String, Mapper> mappers;
    private Connection conn;

    public MapperProxy(Map<String, Mapper> mappers,Connection conn){
        this.conn = conn;
        this.mappers = mappers;
    };
    /**
     * 用于方法的增强，主要用于调用selectList方法
     * @param proxy
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //1、获取代理对象要执行的方法名
        String methodName = method.getName();
        //2、获取代理对象执行方法的所在类包
        String className = method.getDeclaringClass().getName();
        //3、将方法名和类包进行拼接，获取键
        String key = className+"."+methodName;
        //4、通过键，获取mapper对象，并将mapper中的可执行的方法名和封装类包名进行获取
        //判断是否有mapper
        Mapper mapper = mappers.get(key);
        if (mapper == null){
            throw new IllegalArgumentException("传入的参数有误");
        }
        //使用可执行的sql进行准备预编译对象
        return new Executor().selectList(mapper,conn);
    }
}
