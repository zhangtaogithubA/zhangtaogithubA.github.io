package com.itcast.jdbc;

import org.junit.Test;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Jdbc01  {
    public static void main(String[] args) throws Exception{
        //1.导入驱动jar包
        //2.注册驱动
       // Class.forName("com.mysql.cj.Driver");
        //3.获取数据库连接对象
        Connection conn = DriverManager.getConnection( "jdbc:mysql://localhost:3306/db3?useUnicode=true&characterEncoding=UTF8&useSSL=false&serverTimezone=GMT%2B8&useAffectedRows=true","root","tiger");
        /* 4.定义sql语句 */
        String sql = "update account set balance = 750 where id = 1";
        //5.获取执行sq1的对象Statement
        Statement stmt = conn.createStatement() ;
        //6.执行sql
        int count = stmt . executeUpdate(sql);
        //7.处理结果
        System. out . println(count);
        //8.释放资源
        stmt.close();
        conn.close();

    }
    //Connection conn = DriverManager.getConnection( "jdbc:mysql://localhost:3306/osdb?useUnicode=true&characterEncoding=UTF8&useSSL=false&serverTimezone=GMT%2B8&useAffectedRows=true","root","12345678");
    @Test
    public void test() throws Exception{
        //1.导入驱动jar包
        //2.注册驱动
        // Class.forName("com.mysql.cj.Driver");
        //3.获取数据库连接对象
        Connection conn = DriverManager.getConnection( "jdbc:mysql://localhost:3306/osdb?useUnicode=true&characterEncoding=UTF8&useSSL=false&serverTimezone=GMT%2B8&useAffectedRows=true","root","12345678");
        /* 4.定义sql语句 */
        String sql = "select * from category";
        //5.获取执行sq1的对象Statement
        Statement stmt = conn.createStatement() ;
        //6.执行sql
        ResultSet resultSet = stmt.executeQuery(sql);
        //7.处理结果
        while (resultSet.next()){
            System.out.println(resultSet.getString(3));
        }
        //8.释放资源
        stmt.close();
        conn.close();
    }
}
