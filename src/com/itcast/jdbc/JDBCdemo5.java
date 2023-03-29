package com.itcast.jdbc;

import java.sql.*;

public class JDBCdemo5 {

    //account表 修改记录

    public static void main(String[] args) {
        Statement stmt =null;
        Connection conn = null;
        ResultSet  rs  =  null;
        try {
            // 1.注册驱动
            // 2.定义sql
            String sql = "select * from account";
            // 3.获取Connection对象
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db3?useUnicode=true&characterEncoding=UTF8&useSSL=false&serverTimezone=GMT%2B8&useAffectedRows=true", "root", "tiger");
            //4.获取执行sq1的对象Statement
            stmt = conn.createStatement();
            //5.执行sq1
            rs = stmt.executeQuery(sql);//影响的行数，遍历
            //6.处理结果
           // System.out.println(count);
            //6.1  让光标向下移动一行
            rs.next();
            //6.2 获取数据
            int id = rs.getInt(1);
            String name = rs.getString("name");
            double balance = rs.getDouble(3);

            System.out.println(id + "---" +name + "---" + balance);

       } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            //stmt.close();
            //7.释放资源
            //避免空指针异常
            if(rs != null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(stmt != null){
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(conn != null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}


