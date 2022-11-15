package JDBC.JDBCPoolTransacciones.services;

import JDBC.JDBCPoolTransacciones.models.Category;
import JDBC.JDBCPoolTransacciones.models.Product;

import java.sql.SQLException;
import java.util.List;

public interface Servicio {
    List<Product> getAllProduct() throws SQLException;

    Product productById(Long id) throws SQLException;

    Product saveProduct(Product product) throws SQLException;

    void deleteProduct(Long id) throws SQLException;


    List<Category> getAllCategory() throws SQLException;

    Category categoryById(Long id) throws SQLException;

    Category saveCategory(Category category) throws SQLException;

    void deleteCategory(Long id) throws SQLException;

    void saveProductWithCategory(Product product, Category category);
}
