package JDBC.JDBCSingletonTransacciones;

import JDBC.JDBCSingletonTransacciones.exceptions.PersistantException;
import JDBC.JDBCSingletonTransacciones.factory.MySQLAdapter;
import JDBC.JDBCSingletonTransacciones.models.Category;
import JDBC.JDBCSingletonTransacciones.models.Product;
import JDBC.JDBCSingletonTransacciones.repository.Repository;
import JDBC.JDBCSingletonTransacciones.repository.product.ProductDAOImp;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

public class EjemploJDBCSave {
    public static void main(String[] args) {

        try (Connection connection = MySQLAdapter.getConnection()) {
            Repository<Product> repository = new ProductDAOImp();
            System.out.println("\n========== obtener por ID ==========");
            System.out.println(repository.getById(2L));

            System.out.println("\n========== listar ==========");
            repository.getAll().forEach(System.out::println);

            System.out.println("\n========== insertar producto ==========");
            Product producto = new Product();
            producto.setNombre("Teclado mecánico RedDragon");
            producto.setPrecio(750);
            producto.setFechaRegistro(new Date());

            Category category = new Category();
            category.setId(3L);

            producto.setCategory(category);
            repository.save(producto);
            System.out.println("producto guardado con exito");
            repository.getAll().forEach(System.out::println);
        } catch (PersistantException | SQLException e) {
            e.printStackTrace();
        }
    }
}
