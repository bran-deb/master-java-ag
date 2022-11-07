package JDBC.JDBCAutoClose.factory;

import JDBC.JDBCAutoClose.exceptions.PersistantException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLAdapter {
    //ABRE CONNEXION CADA QUE HACEMOS UNA CONSULTA
    public static Connection getConnection() {
        String url = "jdbc:mysql://localhost:3306/java-jdbc-ag?zeroDateTimeBehavior=convertToNull&serverTimezone=America/La_Paz";
        String username = "root";
        String password = "diosdeb";
        try {
            return DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            throw new PersistantException("Cannot connect to DB", e);
        }
    }
}
