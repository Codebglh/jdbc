package com.bgcode.jdbc.mysql.statemento;

import com.mysql.cj.jdbc.Driver;

import java.sql.*;
import java.util.Properties;

/**
 * @time : 2023/1/20 44
 * @author: bgcode
 */
public class ResultSet_ {
    public static void main(String[] args) throws SQLException {
        //1、创建一个Driver类
        Driver driver = new Driver();//创建一个Driver对象
        String url = "jdbc:mysql://localhost:3306/test";//数据库具体链接
        //2、填写密码及账户链接数据库
        Properties properties = new Properties();
        properties.setProperty("user", "root");
        properties.setProperty("password", "liuhonga");
        Connection connect = driver.connect(url, properties);
        //3、执行sql
//        String sql = "insert into bg values(3,'li','sa','1970-12-11','100')";
//        String sql = "update bg set name='2w' where id=1";
//        String sql = "delete from bg where id=3";
        String sql = "select id,name,gender,date ,phone from bg ";
        Statement statement = connect.createStatement();//用于执行静态SQL并返回其生成结果的对象
//        statement.executeUpdate(sql);//executeUpdate进行增删改查
        ResultSet resultSet = statement.executeQuery(sql);//查询语句executeQuery
        while (resultSet.next()) {
            int id = resultSet.getInt(1);
            String name = resultSet.getString(2);
            String ge = resultSet.getString(3);
            Date date = resultSet.getDate(4);
            String p = resultSet.getString(5);
            System.out.print(id + "\t" + name + "\t" + ge + "\t" + date + "\t" + p + "\n");
        }
        //4、关闭链接资源
        statement.close();
        connect.close();
    }
}
