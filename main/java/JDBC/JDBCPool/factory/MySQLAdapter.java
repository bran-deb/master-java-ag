package JDBC.JDBCPool.factory;

import JDBC.JDBCPool.exceptions.PersistantException;
import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class MySQLAdapter {
    private static BasicDataSource pool;

    //POOL DE CONEXIONES (INSTANCIAS LISTAS) CON APACHE COMMONS
    public static BasicDataSource getInstance() {
        String url = "jdbc:mysql://localhost:3306/java-jdbc-ag?zeroDateTimeBehavior=convertToNull&serverTimezone=America/La_Paz";
        String username = "root";
        String password = "diosdeb";

        if (pool == null) {
            pool = new BasicDataSource();
            pool.setUrl(url);
            pool.setUsername(username);
            pool.setPassword(password);
            pool.setInitialSize(3);     //inicia con 3 conexiones abiertas
            pool.setMinIdle(3);         //minima de conexiones esperando
            pool.setMinIdle(8);         //maximo de 8 conexiones esperando
            pool.setMaxTotal(8);        //total
        }
        return pool;
    }

    //RETORNA LAS CONEXIONES ABIERTAS
    public static Connection getConnexion() {
        try {
            return getInstance().getConnection();
        } catch (SQLException e) {
            throw new PersistantException("Error while getting DB connection", e);
        }
    }
}
