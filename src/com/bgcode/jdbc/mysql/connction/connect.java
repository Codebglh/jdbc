package com.bgcode.jdbc.mysql.connction;

import com.mysql.cj.jdbc.Driver;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @time : 2023/1/20 08
 * @author: bgcode
 */
public class connect {
    @Test
    public void connection1() throws SQLException {
        Driver driver = new Driver();//创建一个Driver对象
        String url = "jdbc:mysql://localhost:3306/test";//数据库具体链接
        //2、填写密码及账户链接数据库
        Properties properties = new Properties();
        properties.setProperty("user", "root");
        properties.setProperty("password", "liuhonga");
        Connection connect = driver.connect(url, properties);
        System.out.print(connect);
        connect.close();
    }

    @Test

    public void connection2() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        //使用反射加载
        Class<?> aClass = Class.forName("com.mysql.cj.jdbc.Driver");
        Driver driver = (Driver) aClass.newInstance();
        String url = "jdbc:mysql://localhost:3306/test";//数据库具体链接
        //2、填写密码及账户链接数据库
        Properties properties = new Properties();
        properties.setProperty("user", "root");
        properties.setProperty("password", "liuhonga");
        Connection connect = driver.connect(url, properties);
        System.out.print(connect);
        connect.close();
    }

    @Test
//方式3使用DriverManager替代driver进行统一管理
    public void connection3() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        //1、使用反射加载
        Class<?> aClass = Class.forName("com.mysql.cj.jdbc.Driver");
        Driver driver = (Driver) aClass.newInstance();
        //2、填写密码及账户链接数据库
        String url = "jdbc:mysql://localhost:3306";//数据库具体链接
        String user = "root";
        String password = "liuhonga";
        DriverManager.registerDriver(driver);//注册Driver驱动

        Connection connect = DriverManager.getConnection(url, user, password);
        System.out.print(connect);
        connect.close();
    }

    @Test
//方式4自动注册简化代码
    public void connection4() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        //1、使用反射加载
        Class.forName("com.mysql.cj.jdbc.Driver");

        //2、填写密码及账户链接数据库
        String url = "jdbc:mysql://localhost:3306";//数据库具体链接
        String user = "root";
        String password = "liuhonga";


        Connection connect = DriverManager.getConnection(url, user, password);
        System.out.print(connect);
        connect.close();
    }

    //方式5分离方式方法推荐使用
    @Test
    public void connection5() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException, IOException {

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
        System.out.print(connect);
        connect.close();
    }
}
