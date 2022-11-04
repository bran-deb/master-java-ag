package JDBC.factory;

import JDBC.exceptions.PersistantException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostGreSQLAdapter {
    private static Connection connection;

    public static Connection getConnection() {
        if (connection == null) {
            String url = "jdbc:postgresql://localhost:5432/java-jdbc-ag";
            String username = "root";
            String password = "diosdeb";
            try {
                connection = DriverManager.getConnection(url, username, password);
            } catch (SQLException e) {
                throw new PersistantException("Error while getting DB connection", e);
            }
        }
        return connection;
    }
}
