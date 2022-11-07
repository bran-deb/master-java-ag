package JDBC.JDBCSingleton.repository.product;

import JDBC.JDBCSingleton.exceptions.PersistantException;
import JDBC.JDBCSingleton.factory.MySQLAdapter;
import JDBC.JDBCSingleton.models.Category;
import JDBC.JDBCSingleton.models.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAOImp extends ProductDAO {

    //SEPARAR ACOPLAMIENTO
    private Connection getConnection() {
        return MySQLAdapter.getConnection();
    }


    @Override
    public List<Product> getAll() {
        String sql = "SELECT p.*, c.nombre as category " +
                "FROM productos as p inner join categorias as c " +
                "ON (p.categoria_id = c.id)";
        List<Product> products = new ArrayList<>();

        try (Statement statement = getConnection().createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                Product product = getProduct(resultSet);
                products.add(product);
            }
        } catch (SQLException e) {
            throw new PersistantException("Error while get all of DB", e);
        }
        return products;
    }


    @Override
    public Product getById(Long id) {
        String sql = "SELECT p.*, c.nombre as category " +
                "FROM productos as p inner join categorias as c " +
                "ON (p.categoria_id = c.id)" +
                " WHERE p.id = ?";
        Product product = null;

        try (PreparedStatement statement = getConnection().prepareStatement(sql)) {
            statement.setLong(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {//auto close para ResultSet
                if (resultSet.next()) {
                    product = getProduct(resultSet);
                }
            }
        } catch (SQLException e) {
            throw new PersistantException("Error while finding in DB", e);
        }
        return product;
    }


    @Override
    public void save(Product product) {
        String sql;

        if (product.getId() != null && product.getId() > 0) {
            sql = "UPDATE productos SET nombre=?,precio=?, categoria_id=? WHERE id=?";
        } else {
            sql = "INSERT INTO productos(nombre, precio, categoria_id, fecharegistro) VALUES(?,?,?,?)";
        }

        try (PreparedStatement statement = getConnection().prepareStatement(sql)) {
            statement.setString(1, product.getNombre());
            statement.setInt(2, product.getPrecio());
            statement.setLong(3, product.getCategory().getId());
            if (product.getId() != null && product.getId() > 0) {
                statement.setLong(4, product.getId());
            } else {
                statement.setDate(4, new Date(product.getFechaRegistro().getTime()));
                //statement.setDate(3, new Date(product.getFechaRegistro().getTime()));
            }
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new PersistantException("Error while saving in DB", e);
        }
    }


    @Override
    public void delete(Long id) {
        String sql = "DELETE FROM productos WHERE id=?";
        try (PreparedStatement statement = getConnection().prepareStatement(sql)) {
            statement.setLong(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new PersistantException("Error while delete in DB", e);
        }
    }


    private Product getProduct(ResultSet resultSet) throws SQLException {
        Product product = new Product();
        product.setId(resultSet.getLong("id"));
        product.setNombre(resultSet.getString("nombre"));
        product.setPrecio(resultSet.getInt("precio"));
        product.setFechaRegistro(resultSet.getDate("fecharegistro"));

        Category category = new Category();
        category.setId(resultSet.getLong("categoria_id"));
        category.setNombre(resultSet.getString("category"));

        product.setCategory(category);
        return product;
    }
}
