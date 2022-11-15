package JDBC.JDBCPoolTransacciones;

import JDBC.JDBCPoolTransacciones.models.Category;
import JDBC.JDBCPoolTransacciones.models.Product;
import JDBC.JDBCPoolTransacciones.services.CatalogoService;
import JDBC.JDBCPoolTransacciones.services.Servicio;

import java.sql.SQLException;
import java.util.Date;

public class EjemploJDBCSave {
    public static void main(String[] args) throws SQLException {

        Servicio servicio = new CatalogoService();
        System.out.println("\n========== listar ==========");
        servicio.getAllProduct().forEach(System.out::println);

        Category category = new Category();
        category.setNombre("Iluminación");

        System.out.println("\n========== insertar producto ==========");
        Product producto = new Product();
        producto.setNombre("Lampara normal");
        producto.setPrecio(990);
        producto.setFechaRegistro(new Date());
        producto.setSku("abcd123");
        servicio.saveProductWithCategory(producto, category);
        System.out.println("categoría guardado con exito:" + producto.getId());
        servicio.getAllProduct().forEach(System.out::println);
    }
}
