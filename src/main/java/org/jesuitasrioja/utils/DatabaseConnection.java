package org.jesuitasrioja.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static Connection con = null;

    public static Connection getConnection()
    {
        String url = "jdbc:mysql://192.168.56.101:3306/AD_Hospital";
        String user = "user";
        String pass = "user";
        try {
            //Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, user, pass);
            System.out.println("Conexion establecida");
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }
}

