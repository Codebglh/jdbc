package com.bgcode.jdbc.mysql.connct1;

import com.mysql.cj.jdbc.Driver;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * @time : 2023/1/20 35
 * @author: bgcode
 */
public class jdbc1 {
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
        String sql = "insert into bg values(null,'li','sa','1970-12-11','100')";
//        String sql = "update bg set name='2w' where id=1";
//        String sql = "delete from bg where id=3";
        Statement statement = connect.createStatement();//用于执行静态SQL并返回其生成结果的对象
        statement.executeUpdate(sql);//executeUpdate进行增删改查
        //4、关闭链接资源
        statement.close();
        connect.close();

    }
}
