package JDBC.JDBCAutoClose;

import JDBC.JDBCAutoClose.models.Product;
import JDBC.JDBCAutoClose.repository.Repository;
import JDBC.JDBCAutoClose.repository.product.ProductDAOImp;

public class EjemploJDBCDelete {
    public static void main(String[] args) {

        Repository<Product> repository = new ProductDAOImp();
        System.out.println("\n========== listar ==========");
        repository.getAll().forEach(System.out::println);

        System.out.println("\n========== eliminar producto ==========");
        repository.delete(3L);
        System.out.println("producto eliminado con exito");
        repository.getAll().forEach(System.out::println);
    }
}
