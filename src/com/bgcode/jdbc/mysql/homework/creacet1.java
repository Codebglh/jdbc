package com.bgcode.jdbc.mysql.homework;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

/**
 * @time : 2023/1/20 06
 * @author: bgcode
 */
public class creacet1 {
    public static void main(String[] args) throws Exception {
        Properties properties = new Properties();
        properties.load(new FileInputStream("src/mysql.properites"));
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String url = properties.getProperty("url1");
        String driver = properties.getProperty("driver");
        //1、使用反射加载
        Class.forName(driver);
        //2、填写密码及账户链接数据库
        Connection connect = DriverManager.getConnection(url, user, password);
        String sql = "create database if not exists ba character set utf8mb4";//创建数据库
        //得到prepare-statement对象
        PreparedStatement preparedStatement = connect.prepareStatement(sql);
//        preparedStatement.execute(sql);
//        String sql1 = " drop database if exists ba";//删除数据库
//
//        preparedStatement.executeUpdate(sql1);


        String sql2 = "create table  if not exists ba.b2g  ( `id` int NOT NULL AUTO_INCREMENT,`name` varchar(255) DEFAULT NULL,`pwd` varchar(255) DEFAULT NULL, PRIMARY KEY (`id`)                )ENGINE = InnoDB AUTO_INCREMENT = 5 DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ";
        preparedStatement.executeUpdate(sql2);
//        for (int i = 0; i < 5; i++) {
//            String sq2l = " INSERT INTO ba. bg ( `name`, `pwd`) VALUES ('ds', '2');\n";
//
//            preparedStatement.executeUpdate(sq2l);
//        }
        String sql22 = "select * from ba.bg";

        ResultSet rs = preparedStatement.executeQuery(sql22);
        while (rs.next()) {
            int id = rs.getInt(1);
            String name = rs.getString(2);

            String pwd = rs.getString(3);
            System.out.print(id + "\t" + name + "\t" + pwd + "\n");
        }
        connect.close();
        preparedStatement.close();
    }
}
