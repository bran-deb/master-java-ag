package anotaciones.procesador;

import anotaciones.JsonAtributo;
import anotaciones.exceptions.JsonSerializadorException;

import java.lang.reflect.Field;
import java.util.Arrays;

public class JsonSerializador {
    public static String convertirJson(Object object) {

        if (object == null) {
            throw new JsonSerializadorException("El objeto serializar no puede ser null");
        }

        Field[] atributos = object.getClass().getDeclaredFields();
        //filtra los campos que tienen la annotation de JsonAtributo
        return Arrays.stream(atributos)
                .filter(field -> field.isAnnotationPresent(JsonAtributo.class))
                .map(field -> {
                    field.setAccessible(true);  //si el campo es private se puede acceder mediante reflexion
                    String nombre = field.getAnnotation(JsonAtributo.class).nombre().equals("")     //accede al atributo de la annotation
                            ? field.getName()
                            : field.getAnnotation(JsonAtributo.class).nombre();

                    try {
                        Object valor = field.get(object);
                        //capitalizar
                        if (field.getAnnotation(JsonAtributo.class).capitalizar() && valor instanceof String) {
                            String nuevoValor = (String) valor;
                            nuevoValor = nuevoValor.substring(0, 1).toUpperCase() + nuevoValor.substring(1).toLowerCase();
                            field.set(object, nuevoValor);
                        }
                        return "\"" + nombre + "\":\"" + field.get(object) + "\"";
                    } catch (IllegalAccessException e) {
                        throw new JsonSerializadorException("Error al serializar el json", e);
                    }
                })
                .reduce("{", (a, b) -> {
                    if ("{".equals(a)) {
                        return a + b;
                    }
                    return a + ", " + b;
                })
                .concat("}");
    }
}
