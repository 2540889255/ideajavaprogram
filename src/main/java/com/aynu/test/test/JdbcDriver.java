package com.aynu.test.test;

import java.sql.*;

public class JdbcDriver {


    public static void main(String[] args) throws SQLException {
        try {
            Class<?> aClass = Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String username="";
        String password="";
        Connection connection = null;
        Statement statement = null;
        ResultSet execute = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/***?serverTimezone=UTC",username,password);
            statement = connection.createStatement();
             execute = statement.executeQuery("select * from user_info where username=\"张三\"");

            while (execute.next()){
                System.out.println(execute.getObject(1));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            execute.close();
            statement.close();
            connection.close();
        }
    }



}





