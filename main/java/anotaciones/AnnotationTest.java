package anotaciones;

import anotaciones.models.Producto;
import anotaciones.procesador.JsonSerializador;

import java.lang.reflect.Field;
import java.time.LocalDate;
import java.util.Arrays;

public class AnnotationTest {
    public static void main(String[] args) {

        Producto producto = new Producto();
        producto.setFecha(LocalDate.now());
        producto.setNombre("Mesa de centro roble");
        producto.setPrecio(1000L);

        System.out.println("json = " + JsonSerializador.convertirJson(producto));
    }
}
