package com.test.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBHelper {
    public static final String url = "jdbc:mysql://localhost:3306/direct seeding";
    public static final String driver = "com.mysql.jdbc.Driver";
    public static final String user = "root";
    public static final String password = "123456";
    public Connection conn = null;
    public PreparedStatement pst = null;
    static {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public DBHelper() {
    }

    public DBHelper(String sql) {
        try {
            conn = DriverManager.getConnection(url,user,password);//2、建立连接对象conn
            pst = conn.prepareStatement(sql);//3、创建prepareStatement对象
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //建立连接之后，发送语句，执行语句或者返回结果集处理需在调用者自己的方法里
        //因为不同的调用者会有不同的sql语句，进行传递实参sql语句，以及在各自的方法里处理结果集(select)
        //while (rs.next()){//5、处理结果集(只处理select语句返回结果)
        //int row = pstmt.executeUpdate();4、向数据库发送sql语句，执行sql语句，必不可少
        //System.out.println(row);
    }

    public Connection getConn(){
        try {
            conn = DriverManager.getConnection(url,user,password);//返回连接对象conn
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public void close(){
        try {
            this.pst.close();
            this.conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
