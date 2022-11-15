package JDBC.JDBCPoolTransacciones.factory;

import java.sql.Connection;

public interface DBAdapter {
    Connection getConnection();
}
