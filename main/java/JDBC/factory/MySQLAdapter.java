package JDBC.factory;

import JDBC.exceptions.PersistantException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//public abstract class MySQLAdapter implements DBAdapter {
public class MySQLAdapter {
    private static Connection connection;   //singleton

    //@Override
    public static Connection getConnection() {
        if (connection == null) {
            try {
                String url = "jdbc:mysql://localhost:3306/java-jdbc-ag?zeroDateTimeBehavior=convertToNull&serverTimezone=America/La_Paz";
                String username = "root";
                String password = "diosdeb";
                connection = DriverManager.getConnection(url, username, password);
            } catch (SQLException e) {
                throw new PersistantException("Error while getting DB connection", e);
            }
        }
        return connection;
    }
}
