package JDBC.JDBCPoolTransacciones.repository.product;

import JDBC.JDBCPoolTransacciones.exceptions.PersistantException;
import JDBC.JDBCPoolTransacciones.models.Category;
import JDBC.JDBCPoolTransacciones.models.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAOImp extends ProductDAO {

    //SEPARAR ACOPLAMIENTO
    private Connection connection;

    public ProductDAOImp() {
    }

    public ProductDAOImp(Connection connection) {
        this.connection = connection;
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Product> getAll() {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT p.*, c.nombre as category " +
                "FROM productos as p inner join categorias as c " +
                "ON (p.categoria_id = c.id)";

        try (Statement statement = connection.createStatement();
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
        Product product = null;
        String sql = "SELECT p.*, c.nombre as category " +
                "FROM productos as p inner join categorias as c " +
                "ON (p.categoria_id = c.id)" +
                " WHERE p.id = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
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
    public Product save(Product product) {
        String sql;

        if (product.getId() != null && product.getId() > 0) {
            sql = "UPDATE productos SET nombre=?,precio=?, categoria_id=?, sku=? WHERE id=?";
        } else {
            sql = "INSERT INTO productos(nombre, precio, categoria_id, sku, fecharegistro) VALUES(?,?,?,?,?)";
        }

        try (PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, product.getNombre());
            statement.setInt(2, product.getPrecio());
            statement.setLong(3, product.getCategory().getId());
            statement.setString(4, product.getSku());
            if (product.getId() != null && product.getId() > 0) {
                statement.setLong(5, product.getId());
            } else {
                statement.setDate(5, new Date(product.getFechaRegistro().getTime()));
            }
            statement.executeUpdate();

            if (product.getId() == null) {
                try (ResultSet resultSet = statement.getGeneratedKeys()) {
                    if (resultSet.next()) {
                        product.setId(resultSet.getLong(1));
                    }
                }
            }
        } catch (SQLException e) {
            throw new PersistantException("Error while saving in DB", e);
        }
        return product;
    }


    @Override
    public void delete(Long id) {
        String sql = "DELETE FROM productos WHERE id=?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
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
