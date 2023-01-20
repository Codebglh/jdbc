package com.bgcode.jdbc.mysql.dml;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;
import java.util.Scanner;

/**
 * @time : 2023/1/20 48
 * @author: bgcode
 */
public class lianjie {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入登陆名:");
        String a = scanner.nextLine();
//        System.out.print("请输入密" + "\t" + "码:");
//        String b = scanner.nextLine();
        Properties properties = new Properties();
        properties.load(new FileInputStream("src/mysql.properites"));
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String url = properties.getProperty("url");
        String driver = properties.getProperty("driver");
        //1、使用反射加载
        Class.forName(driver);
        //2、填写密码及账户链接数据库
        Connection connect = DriverManager.getConnection(url, user, password);
//        String sql = "insert into admin values (?,?)";//增加
//        String sql = "update admin set pwd=? where name=?";//更改
        String sql = "delete from admin where name=?";//删除
        //得到preparestatement对象
        PreparedStatement preparedStatement = connect.prepareStatement(sql);
        //给？赋值
//        preparedStatement.setString(1, a);
//        preparedStatement.setString(2, b);
//        preparedStatement.setString(1, b);
//        preparedStatement.setString(2, a);
        preparedStatement.setString(1, a);
        //插入数据
        System.out.print(preparedStatement.executeUpdate() > 0 ? "true" : "false");
        connect.close();
        preparedStatement.close();

    }
}
