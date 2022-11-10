package JDBC.JDBCSingletonTransacciones.repository;

import java.sql.SQLException;
import java.util.List;

//CONSULTAS Y OPERACIONES EN LA DB
public interface Repository<T> {

    List<T> getAll();

    T getById(Long id);

    void save(T t);

    void edit(T t);

    void delete(Long id);
}
