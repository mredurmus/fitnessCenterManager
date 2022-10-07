package com.example.projefx;

import java.sql.*;

public class DBConnection {
    private static String id = "DB_ID";
    private static String passwd = "DB_PSWRD";
    private static String url = "DB_URL";

    public static Connection getConnection() throws SQLException {
        Connection connection = DriverManager.getConnection(url,id,passwd);
        return connection;
    }
    public void ShowError(SQLException execpt){
        System.out.println("Error :" + execpt.getMessage());
    }
}
