package JDBC.JDBCPool;

import JDBC.JDBCPool.models.Category;
import JDBC.JDBCPool.models.Product;
import JDBC.JDBCPool.repository.Repository;
import JDBC.JDBCPool.repository.product.ProductDAOImp;

public class EjemploJDBCUpdate {
    public static void main(String[] args) {

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
    }
}
