package anotaciones;

import anotaciones.models.Producto;

import java.lang.reflect.Field;
import java.time.LocalDate;
import java.util.Arrays;

public class AnnotationTest {
    public static void main(String[] args) {

        Producto producto = new Producto();
        producto.setFecha(LocalDate.now());
        producto.setNombre("Mesa de centro roble");
        producto.setPrecio(1000L);

        Field[] atributos = producto.getClass().getDeclaredFields();
        //filtra los campos que tienen la annotation de JsonAtributo
        String json = Arrays.stream(atributos)
                .filter(field -> field.isAnnotationPresent(JsonAtributo.class))
                .map(field -> {
                    field.setAccessible(true);  //si el campo es private se puede acceder mediante reflexion
                    String nombre = field.getAnnotation(JsonAtributo.class).nombre().equals("")     //accede al atributo de la annotation
                            ? field.getName()
                            : field.getAnnotation(JsonAtributo.class).nombre();
                    try {
                        return "\"" + nombre + "\":\"" + field.get(producto) + "\"";
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException("Error al serializar el json" + e.getMessage());
                    }
                })
                .reduce("{", (a, b) -> {
                    if ("{".equals(a)) {
                        return a + b;
                    }
                    return a + ", " + b;
                })
                .concat("}");
        System.out.println("json = " + json);


        System.out.println("" + "\":\"");
    }
}
