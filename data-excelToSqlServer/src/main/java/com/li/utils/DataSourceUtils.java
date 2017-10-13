package com.li.utils;

import java.sql.Connection;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class DataSourceUtils {  
    private static DataSource ds;  
    //声明ThreadLocal容器对象  
    private static ThreadLocal<Connection> tl = new ThreadLocal<Connection>();  
    static {  
        ds = // 默认的读取c3p0-config.xml中默认配置   
        new ComboPooledDataSource();   
    }  
    public static DataSource getDatasSource() {  
        return ds;   
    }     
    //提供一个返回Connection的方法  
    public static Connection getConn(){  
        Connection con = null;  
        //先从tl中获取数据  
        con = tl.get();  
        if(con==null){  
            try{  
                con = getDatasSource().getConnection();  
                //放到tl  
                tl.set(con);   
            }catch(Exception e){  
                e.printStackTrace();  
            }  
        }  
        return con;   
    }  
    public static void remove() {  
        tl.remove();  
    }  
}  
