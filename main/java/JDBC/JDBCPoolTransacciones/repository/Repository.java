package JDBC.JDBCPoolTransacciones.repository;

import java.sql.Connection;
import java.util.List;

//CONSULTAS Y OPERACIONES EN LA DB
public interface Repository<T> {

    void setConnection(Connection connection);

    List<T> getAll();

    T getById(Long id);

    T save(T t);

    void edit(T t);

    void delete(Long id);
}
