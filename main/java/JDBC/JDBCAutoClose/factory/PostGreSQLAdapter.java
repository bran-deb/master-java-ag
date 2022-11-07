package JDBC.JDBCAutoClose.factory;

import JDBC.JDBCAutoClose.exceptions.PersistantException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostGreSQLAdapter {

    public static Connection getConnection() {
        String url = "jdbc:postgresql://localhost:5432/java-jdbc-ag";
        String username = "root";
        String password = "diosdeb";
        try {
            return DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            throw new PersistantException("Cannot connect to DB", e);
        }
    }
}
