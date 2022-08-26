package org.pre.handler.impl;

import org.pre.handler.ResultSetHandler;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

/**
 * 结果集封装的具体实现类、
 * 该类实现的是把一个结果集的内容封装到一个指定的实体类对象中
 * 使用要求：实体类中属性必须和表中列名一致
 * @param <T>
 */
public class BeanHandler<T> implements ResultSetHandler<T> {
    private Class<T> pojoClass;

    public BeanHandler(Class<T> pojoClass){
        this.pojoClass = pojoClass;
    }

    /**
     * 把结果集封装到具体类中
     * @param res
     * @return
     */
    public T handler(ResultSet res) {
        try{
            //1、创建一个实体类对象
            T bean = pojoClass.newInstance();
            //2、判断是否结果集
            if(res.next()){
                //3、得到结果集中所有列名，
                //想要得到列名得先得到结果集的源信息
                ResultSetMetaData remd = res.getMetaData();
                //得到源信息后，还要得知存在多少列
                int columnCount = remd.getColumnCount();
                //遍历列数
                for(int i = 1;i<=columnCount;i++){
                    //得到每列的名称
                    String catalogName = remd.getCatalogName(i);
                    //列名其实就是实体类的属性名称，于是可以使用列名得到实体类中属性的描述器
                    //描述器：实体类中定义的私有成员的get和set方法
                    PropertyDescriptor pd = new PropertyDescriptor(catalogName, pojoClass);
                    //获取属性的写入方法
                    Method writeMethod = pd.getWriteMethod();
                    //获取当前列名所对应的值
                    Object columnValue = res.getObject(columnCount);
                    //通过执行写方法把得到的值给属性赋值
                    writeMethod.invoke(bean,columnValue);
                }
            }
            return bean;
        }catch (Exception e){
            throw new RuntimeException("出现运行时异常");
        }
    }
}
