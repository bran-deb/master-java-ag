package JDBC.JDBCPoolTransacciones.repository.category;

import JDBC.JDBCPoolTransacciones.models.Category;
import JDBC.JDBCPoolTransacciones.repository.Repository;

import java.sql.Connection;
import java.util.List;

public class CategoryDAO implements Repository<Category> {

    @Override
    public void setConnection(Connection connection) {

    }

    @Override
    public List<Category> getAll() {
        return null;
    }

    @Override
    public Category getById(Long id) {
        return null;
    }

    @Override
    public Category save(Category category) {
        return null;
    }

    @Override
    public void edit(Category category) {

    }

    @Override
    public void delete(Long id) {

    }
}
