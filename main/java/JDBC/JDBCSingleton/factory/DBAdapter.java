package JDBC.JDBCSingleton.factory;

import java.sql.Connection;

public interface DBAdapter {
    Connection getConnection();
}
