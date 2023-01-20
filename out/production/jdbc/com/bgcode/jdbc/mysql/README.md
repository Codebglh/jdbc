### 1、数据库

> ```mysql
>CREATE DATABASE if not exists test;
>#     创建数据库
>drop database test;
>#     删除数据库
>use RUNOOB;
>#     使用数据库

### 2、数据类型

>
> ![](https://cdn.jsdelivr.net/gh/Codebglh/img/study/QQ20230120-0.png)
> ![](https://cdn.jsdelivr.net/gh/Codebglh/img/study/QQ20230120-1.png)
> ![](https://cdn.jsdelivr.net/gh/Codebglh/img/study/QQ20230120-2.png)

### 3、表

 ```mysql
CREATE TABLE table_name
(
    `column_name` column_type
);
-- 创建表
 ```

 ```mysql
CREATE TABLE IF NOT EXISTS `runoob_tbl`
(
    `runoob_id`       INT UNSIGNED AUTO_INCREMENT,
    `runoob_title`    VARCHAR(100) NOT NULL,
    `runoob_author`   VARCHAR(40)  NOT NULL,
    `submission_date` DATE,
    PRIMARY KEY (`runoob_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;
 ```

> 如果你不想字段为 NULL 可以设置字段的属性为 NOT NULL， 在操作数据库时如果输入该字段的数据为NULL ，就会报错。
> AUTO_INCREMENT定义列为自增的属性，一般用于主键，数值会自动加1。
> PRIMARY KEY关键字用于定义列为主键。 您可以使用多列来定义主键，列间以逗号分隔。
> ENGINE 设置存储引擎，CHARSET 设置编码。

 ```mysql
DROP TABLE table_name;
-- 删除数据表
 ```

#### SQl语句

> 删除
> ```sqld
> delete from bg where id=2

> 更新
>```sql
> update bg set name='sda'where id=1


> 增加
> ```sql
> INSERT INTO table_name ( field1, field2,...fieldN ) VALUES ( value1, value2,...valueN );

> 复制表
>```sql
>show CREATE TABLE student
>-- 1、显示表结构
>CREATE TABLE `teacher` (
>`id` int NOT NULL AUTO_INCREMENT,
>`email` varchar(255) DEFAULT NULL,
>PRIMARY KEY (`id`)
>) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4   COLLATE=utf8mb4_0900_ai_ci
>-- 2、创建表
>
>INSERT into teacher(email)
>SELECT name FROM bg where phone='100';
>-- 3、复制表
