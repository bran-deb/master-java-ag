package JDBC.JDBCPool;

import JDBC.JDBCPool.models.Category;
import JDBC.JDBCPool.models.Product;
import JDBC.JDBCPool.repository.Repository;
import JDBC.JDBCPool.repository.product.ProductDAOImp;

import java.util.Date;

public class EjemploJDBCSave {
    public static void main(String[] args) {

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
//        repository.save(producto);
        System.out.println("producto guardado con exito");
        repository.getAll().forEach(System.out::println);
    }
}
