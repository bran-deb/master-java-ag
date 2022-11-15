package JDBC.JDBCSingletonTransacciones;

import JDBC.JDBCSingletonTransacciones.exceptions.PersistantException;
import JDBC.JDBCSingletonTransacciones.factory.MySQLAdapter;
import JDBC.JDBCSingletonTransacciones.models.Product;
import JDBC.JDBCSingletonTransacciones.repository.Repository;
import JDBC.JDBCSingletonTransacciones.repository.product.ProductDAOImp;

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
