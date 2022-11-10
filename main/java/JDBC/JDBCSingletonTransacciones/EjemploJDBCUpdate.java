package JDBC.JDBCSingletonTransacciones;

import JDBC.JDBCSingletonTransacciones.exceptions.PersistantException;
import JDBC.JDBCSingletonTransacciones.factory.MySQLAdapter;
import JDBC.JDBCSingletonTransacciones.models.Category;
import JDBC.JDBCSingletonTransacciones.models.Product;
import JDBC.JDBCSingletonTransacciones.repository.Repository;
import JDBC.JDBCSingletonTransacciones.repository.product.ProductDAOImp;

import java.sql.Connection;
import java.sql.SQLException;

public class EjemploJDBCUpdate {
    public static void main(String[] args) {

        try (Connection connection = MySQLAdapter.getConnection()){
            Repository<Product> repository = new ProductDAOImp();
            System.out.println("\n========== listar ==========");
            repository.getAll().forEach(System.out::println);

            System.out.println("\n========== edit ==========");
            Product producto = new Product();
            producto.setId(12L);
            producto.setNombre("Teclado mecánico Razer");
            producto.setPrecio(800);

            Category category = new Category();
            category.setId(2L);

            producto.setCategory(category);
            repository.save(producto);

            System.out.println("producto modificado con exito");
            repository.getAll().forEach(System.out::println);
        } catch (PersistantException | SQLException e) {
            e.printStackTrace();
        }
    }
}
