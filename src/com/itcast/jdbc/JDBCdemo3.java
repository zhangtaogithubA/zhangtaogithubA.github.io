package com.itcast.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCdemo3
{
  //account表 修改记录

        public static void main(String[] args) {
            Statement stmt =null;
            Connection conn = null;
            try {
                // 1.注册驱动
                // 2.定义sql
                String sql = "update account set balance = 1500 where id = 3";
                // 3.获取Connection对象
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db3?useUnicode=true&characterEncoding=UTF8&useSSL=false&serverTimezone=GMT%2B8&useAffectedRows=true", "root", "tiger");
                //4.获取执行sq1的对象Statement
                stmt = conn.createStatement();
                //5.执行sq1
                int count = stmt.executeUpdate(sql);//影响的行数
                //6.处理结果
                System.out.println(count);
                if (count > 0) {
                    System.out.println("修改成功! ");
                } else {
                    System.out.println("修改失败! ");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                //stmt.close();
                //7.释放资源
                //避免空指针异常
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


