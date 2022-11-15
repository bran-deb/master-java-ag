package JDBC.JDBCPoolTransacciones.services;

import JDBC.JDBCPoolTransacciones.factory.MySQLAdapter;
import JDBC.JDBCPoolTransacciones.models.Category;
import JDBC.JDBCPoolTransacciones.models.Product;
import JDBC.JDBCPoolTransacciones.repository.Repository;
import JDBC.JDBCPoolTransacciones.repository.category.CategoryDAOImp;
import JDBC.JDBCPoolTransacciones.repository.product.ProductDAOImp;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class CatalogoService implements Servicio {
    private Repository<Product> productRepository;
    private Repository<Category> categoryRepository;

    public CatalogoService() {
        productRepository = new ProductDAOImp();
        categoryRepository = new CategoryDAOImp();
    }

    @Override
    public List<Product> getAllProduct() throws SQLException {
        try (Connection connection = MySQLAdapter.getConnexion()) {
            productRepository.setConnection(connection);
            return productRepository.getAll();
        }
    }

    @Override
    public Product productById(Long id) throws SQLException {
        try (Connection connection = MySQLAdapter.getConnexion()) {
            productRepository.setConnection(connection);
            return productRepository.getById(id);
        }
    }

    @Override
    public Product saveProduct(Product product) throws SQLException {
        try (Connection connection = MySQLAdapter.getConnexion()) {
            productRepository.setConnection(connection);
            if (connection.getAutoCommit()) {
                connection.setAutoCommit(false);
            }
            Product newProduct = null;
            try {
                newProduct = productRepository.save(product);
                connection.commit();
            } catch (SQLException e) {
                connection.rollback();
                e.printStackTrace();
            }
            return newProduct;
        }
    }

    @Override
    public void deleteProduct(Long id) throws SQLException {
        try (Connection connection = MySQLAdapter.getConnexion()) {
            productRepository.setConnection(connection);
            if (connection.getAutoCommit()) {
                connection.setAutoCommit(false);
            }
            try {
                productRepository.delete(id);
                connection.commit();
            } catch (SQLException e) {
                connection.rollback();
                e.printStackTrace();
            }
        }
    }

    @Override
    public List<Category> getAllCategory() throws SQLException {
        try (Connection connection = MySQLAdapter.getConnexion()) {
            categoryRepository.setConnection(connection);
            return categoryRepository.getAll();
        }
    }

    @Override
    public Category categoryById(Long id) throws SQLException {
        try (Connection connection = MySQLAdapter.getConnexion()) {
            categoryRepository.setConnection(connection);
            return categoryRepository.getById(id);
        }
    }

    @Override
    public Category saveCategory(Category category) throws SQLException {
        try (Connection connection = MySQLAdapter.getConnexion()) {
            categoryRepository.setConnection(connection);
            if (connection.getAutoCommit()) {
                connection.setAutoCommit(false);
            }
            Category newCategory = null;
            try {
                newCategory = categoryRepository.save(category);
                connection.commit();
            } catch (SQLException e) {
                connection.rollback();
                e.printStackTrace();
            }
            return newCategory;
        }
    }

    @Override
    public void deleteCategory(Long id) throws SQLException {
        try (Connection connection = MySQLAdapter.getConnexion()) {
            categoryRepository.setConnection(connection);
            if (connection.getAutoCommit()) {
                connection.setAutoCommit(false);
            }
            try {
                categoryRepository.delete(id);
                connection.commit();
            } catch (SQLException e) {
                connection.rollback();
            }
        }
    }

    @Override
    public void saveProductWithCategory(Product product, Category category) {
        try (Connection connection = MySQLAdapter.getConnexion()) {
            productRepository.setConnection(connection);
            categoryRepository.setConnection(connection);
            if (connection.getAutoCommit()) {
                connection.setAutoCommit(false);
            }
            try {
                Category newCategory = categoryRepository.save(category);
                product.setCategory(newCategory);
                productRepository.save(product);
                connection.commit();
            } catch (SQLException e) {
                connection.rollback();
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
