package JDBC.JDBCSingleton;

import JDBC.JDBCSingleton.exceptions.PersistantException;
import JDBC.JDBCSingleton.factory.MySQLAdapter;
import JDBC.JDBCSingleton.models.Product;
import JDBC.JDBCSingleton.repository.Repository;
import JDBC.JDBCSingleton.repository.product.ProductDAOImp;

import java.sql.Connection;
import java.sql.SQLException;

public class EjemploJDBCDelete {
    public static void main(String[] args) {

        try (Connection connection = MySQLAdapter.getConnection()) {
            Repository<Product> repository = new ProductDAOImp();
            System.out.println("\n========== listar ==========");
            repository.getAll().forEach(System.out::println);

            System.out.println("\n========== eliminar producto ==========");
            repository.delete(3L);
            System.out.println("producto eliminado con exito");
            repository.getAll().forEach(System.out::println);
        } catch (PersistantException | SQLException e) {
            e.printStackTrace();
        }
    }
}
