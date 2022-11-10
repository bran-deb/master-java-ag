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

public class EjemploJDBCSaveTranscion {
    public static void main(String[] args) {
        //TODO SE GUARDA O SE APLICA ROLLBACK
        try (Connection connection = MySQLAdapter.getConnection()) {
            if (connection.getAutoCommit()) {
                connection.setAutoCommit(false);    //cambiar el autocommit
            }
            try {
                Repository<Product> repository = new ProductDAOImp();
                System.out.println("\n========== listar ==========");
                repository.getAll().forEach(System.out::println);

                System.out.println("\n========== insertar producto ==========");
                Product producto = new Product();
                producto.setNombre("Teclado mecánico RedDragon");
                producto.setPrecio(1500);
                producto.setFechaRegistro(new Date());

                Category category = new Category();
                category.setId(3L);

                producto.setCategory(category);
                producto.setSku("abcde1234");
                repository.save(producto);
                System.out.println("producto guardado con exito");
                repository.getAll().forEach(System.out::println);


                System.out.println("\n========== edit ==========");
                producto = new Product();
                producto.setId(12L);
                producto.setNombre("Teclado mecánico Razer");
                producto.setPrecio(1000);

                category = new Category();
                category.setId(2L);

                producto.setCategory(category);
                producto.setSku("abcde12345");
                repository.save(producto);

                System.out.println("producto modificado con exito");
                repository.getAll().forEach(System.out::println);

                connection.commit();
            } catch (SQLException e) {
                e.printStackTrace();
                connection.rollback();      //descarta los cambios
            }
        } catch (PersistantException | SQLException e) {
            e.printStackTrace();
        }
    }
}
