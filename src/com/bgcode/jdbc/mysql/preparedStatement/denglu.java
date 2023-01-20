package com.bgcode.jdbc.mysql.preparedStatement;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;
import java.util.Scanner;

/**
 * @time : 2023/1/20 24
 * @author: bgcode
 */
public class denglu {


    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入登陆名:");
        String a = scanner.nextLine();
        System.out.print("请输入密" + "\t" + "码:");
        String b = scanner.nextLine();
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
        String sql = "select name ,pwd from admin where name =? and pwd = ?";
        //得到preparestatement对象
        PreparedStatement preparedStatement = connect.prepareStatement(sql);
        //给？赋值
        preparedStatement.setString(1, a);
        preparedStatement.setString(2, b);
        //执行语句
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            System.out.println("登陆成功");
        } else {
            System.out.println("登陆失败");
        }
        resultSet.close();
        preparedStatement.close();
        connect.close();
    }
}
