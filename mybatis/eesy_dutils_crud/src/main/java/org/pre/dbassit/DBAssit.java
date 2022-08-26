package org.pre.dbassit;

import org.pre.handler.ResultSetHandler;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBAssit {
    private DataSource dataSource;

    public DBAssit(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    /**
     * 封装增删改的表操作
     * @param sql
     * @param patr
     */
    public void update(String sql,Object... patr){
        Connection conn = null;
        PreparedStatement pstm = null;
        try{
            //1.获取连接
             conn= dataSource.getConnection();
            //2，从连接和参数的sql语句创建预处理对象
            pstm = conn.prepareStatement(sql);
            //3.得到sql语句参数的源信息
            ParameterMetaData ptmd = pstm.getParameterMetaData();
            //4、判断语句中惨呼的个数与方法参数是否一直
            int patc = ptmd.getParameterCount();
            if(patc == 0){
                throw new RuntimeException("输入sql语句异常");
            }else if(patc == patr.length){
                //5、给sql语句的参数赋值
                for(int i=1;i<=patr.length;i++){
                    pstm.setObject(i,patr[i-1]);
                }
                //6、执行语句
                int i = pstm.executeUpdate();
                //7、返回执行结果
            }else{
                throw new RuntimeException("参数不匹配");
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //关闭资源
            this.release(conn,pstm,null);
        }
    }
    public <T> T query(String sql, ResultSetHandler<T> rest, Object... params){
        Connection conn = null;
        PreparedStatement pstm = null;
       ResultSet res=null;
        try{
            //1.获取连接
            conn= dataSource.getConnection();
            //2，从连接和参数的sql语句创建预处理对象
            pstm = conn.prepareStatement(sql);
            //3.得到sql语句参数的源信息
            ParameterMetaData ptmd = pstm.getParameterMetaData();
            //4、判断语句中惨呼的个数与方法参数是否一直
            int patc = ptmd.getParameterCount();
            if(patc == 0){
                throw new RuntimeException("输入sql语句异常");
            }else if(patc == params.length){
                //5、给sql语句的参数赋值
                for(int i=1;i<=params.length;i++){
                    pstm.setObject(i,params[i-1]);
                }
                //6、执行语句
                res = pstm.executeQuery();
                //7、返回执行结果
                return rest.handler(res);
            }else{
                throw new RuntimeException("参数不匹配");
            }
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("出现异常");
        }finally {
            //关闭资源
            this.release(conn,pstm,res);
        }
    }

    private void release(Connection conn, PreparedStatement pstm, ResultSet rest){
            try{
                conn.close();
            }catch (Exception e){
                e.printStackTrace();
            }
            try{
                pstm.close();
            }catch (Exception e){
                e.printStackTrace();
            }
            try{
                if (rest!=null){
                    rest.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
    }
}
