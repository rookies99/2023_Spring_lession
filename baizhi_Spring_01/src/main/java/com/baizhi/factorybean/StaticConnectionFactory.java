package com.baizhi.factorybean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
    ConnectionFactory cf = new ConnectionFactory();
    cf.getConnection();

    staticConnectionFactory.getConnection();  做为静态工厂来讲主要是避免了创建对象的过程
 */

public class StaticConnectionFactory {
    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/myschool?useSSL=false&amp;allowPublicKeyRetrieval=true", "root", "123456");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
}
