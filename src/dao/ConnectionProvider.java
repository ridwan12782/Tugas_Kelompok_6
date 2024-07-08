package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;

public class ConnectionProvider {
    public static Connection getCon() {
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cms?useSSL=false", "root", "");
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found.");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Connection failed! Check output console.");
            e.printStackTrace();
        }
        return con;
    }
}
