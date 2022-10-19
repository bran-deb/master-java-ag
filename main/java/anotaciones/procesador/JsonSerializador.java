package anotaciones.procesador;

import anotaciones.decorators.Init;
import anotaciones.decorators.JsonAtributo;
import anotaciones.exceptions.JsonSerializadorException;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.stream.Collectors;

public class JsonSerializador {

    public static String convertirJson(Object object) {
        if (object == null) {
            throw new JsonSerializadorException("El objeto serializar no puede ser null");
        }

        inicializarObjeto(object);//anotaciones de método
        Field[] atributos = object.getClass().getDeclaredFields();//anotaciones de atributo
        //filtra los campos que tienen la annotation de JsonAtributo
        return Arrays.stream(atributos)
                .filter(field -> field.isAnnotationPresent(JsonAtributo.class))//filtra los métodos que tengan la anotación JsonAtributo
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
//                            nuevoValor = nuevoValor.substring(0, 1).toUpperCase() + nuevoValor.substring(1).toLowerCase();
                            nuevoValor = Arrays.stream(nuevoValor.split(" "))
                                    .map(palabra -> palabra.substring(0, 1).toUpperCase() + palabra.substring(1).toLowerCase())
                                    .collect(Collectors.joining(" "));

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

    public static void inicializarObjeto(Object object) {
        if (object == null) {
            throw new JsonSerializadorException("El objeto serializar no puede ser null");
        }

        Method[] metodos = object.getClass().getDeclaredMethods();
        Arrays.stream(metodos).filter(method -> method.isAnnotationPresent(Init.class))//filtra los métodos que tengan la anotación init
                .forEach(method -> {
                    method.setAccessible(true);//si el campo es private se puede acceder mediante reflexion

                    try {
                        method.invoke(object);
                    } catch (IllegalAccessException | InvocationTargetException e) {
                        throw new JsonSerializadorException("Error al inicializar, no se puede inicializar objeto", e);
                    }
                });
    }
}
