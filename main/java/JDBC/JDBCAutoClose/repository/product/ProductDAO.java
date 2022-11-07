package JDBC.JDBCAutoClose.repository.product;

import JDBC.JDBCAutoClose.models.Product;
import JDBC.JDBCAutoClose.repository.Repository;

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
