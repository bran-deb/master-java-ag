package JDBC.JDBCSingletonTransacciones.repository.product;

import JDBC.JDBCSingletonTransacciones.models.Product;
import JDBC.JDBCSingletonTransacciones.repository.Repository;

import java.util.List;

public class ProductDAO implements Repository<Product> {

    @Override
    public List<Product> getAll() {
        return null;
    }

    @Override
    public Product getById(Long id) {
        return null;
    }

    @Override
    public void save(Product product) {

    }

    @Override
    public void edit(Product product) {

    }

    @Override
    public void delete(Long id) {

    }
}
