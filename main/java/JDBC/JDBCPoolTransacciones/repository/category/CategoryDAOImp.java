package JDBC.JDBCPoolTransacciones.repository.category;

import JDBC.JDBCPoolTransacciones.exceptions.PersistantException;
import JDBC.JDBCPoolTransacciones.models.Category;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAOImp extends CategoryDAO {

    Connection connection;

    public CategoryDAOImp() {
    }

    public CategoryDAOImp(Connection connection) {
        this.connection = connection;
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Category> getAll() {
        List<Category> categories = new ArrayList<>();
        String sql = "SELECT * FROM categorias";

        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                Category category = getCategory(resultSet);
                categories.add(category);
            }
        } catch (SQLException e) {
            throw new PersistantException("Error while get all of DB", e);
        }
        return categories;
    }


    @Override
    public Category getById(Long id) {
        Category category = new Category();
        String sql = "SELECT * FROM categorias as c WHERE c.id=?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setLong(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    category = getCategory(resultSet);
                }
            }
        } catch (SQLException e) {
            throw new PersistantException("Error while finding in DB", e);
        }
        return category;
    }


    @Override
    public Category save(Category category) {
        String sql;
        if (category.getId() != null && category.getId() > 0) {
            sql = "SELECT categorias SET nombre=? WHERE id=?";
        } else {
            sql = "INSERT INTO categorias(nombre) VALUES(?)";
        }
        try (PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {//id generado del insert
            statement.setString(1, category.getNombre());
            if (category.getId() != null && category.getId() > 0) {
                statement.setLong(2, category.getId());
            }
            statement.executeUpdate();

            if (category.getId() == null) {
                try (ResultSet resultSet = statement.getGeneratedKeys()) {
                    if (resultSet.next()) {
                        category.setId(resultSet.getLong(1));
                    }
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return category;
    }

    @Override
    public void delete(Long id) {
        String sql = "DELETE FROM categorias WHERE id=?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setLong(1, id);
            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private Category getCategory(ResultSet resultSet) throws SQLException {
        Category category = new Category();
        category.setId(resultSet.getLong("id"));
        category.setNombre(resultSet.getString("nombre"));
        return category;
    }
}
