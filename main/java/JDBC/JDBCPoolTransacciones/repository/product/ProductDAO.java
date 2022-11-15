package JDBC.JDBCPoolTransacciones.repository.product;

import JDBC.JDBCPoolTransacciones.models.Product;
import JDBC.JDBCPoolTransacciones.repository.Repository;

import java.sql.Connection;
import java.util.List;

public class ProductDAO implements Repository<Product> {

    @Override
    public void setConnection(Connection connection) {

    }

    @Override
    public List<Product> getAll() {
        return null;
    }

    @Override
    public Product getById(Long id) {
        return null;
    }

    @Override
    public Product save(Product product) {
        return null;
    }

    @Override
    public void edit(Product product) {

    }

    @Override
    public void delete(Long id) {

    }
}
