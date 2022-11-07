package JDBC.JDBCSingleton;

import JDBC.JDBCSingleton.exceptions.PersistantException;
import JDBC.JDBCSingleton.factory.MySQLAdapter;
import JDBC.JDBCSingleton.models.Category;
import JDBC.JDBCSingleton.models.Product;
import JDBC.JDBCSingleton.repository.Repository;
import JDBC.JDBCSingleton.repository.product.ProductDAOImp;

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
