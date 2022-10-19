package anotaciones.decorators;

import java.lang.annotation.*;

//@Inherited Herencia (en la clase padre)
@Documented //agrega al API doc
@Target(ElementType.FIELD)   //donde se aplica la notation(field => atributo)
@Retention(RetentionPolicy.RUNTIME)//tiempo de ejecución
public @interface JsonAtributo {

    String nombre() default "";
    boolean capitalizar() default false;
}
