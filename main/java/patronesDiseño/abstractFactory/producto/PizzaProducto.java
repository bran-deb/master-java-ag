package patronesDiseño.abstractFactory.producto;

import java.util.ArrayList;
import java.util.List;

public abstract class PizzaProducto {

    protected String masa;
    protected String salsa;
    protected List<String> ingredientes;
    protected String nombre;

    public PizzaProducto() {
        ingredientes = new ArrayList<>();
    }

    public void preparar() {
        System.out.println("Preparando: " + this.nombre);
        System.out.println("Seleccionando la masa: " + this.masa);
        System.out.println("Agregamos salsa: " + this.salsa);
        System.out.println("agregando ingredientes" + this.ingredientes);
        System.out.println("Ingredientes:");
        this.ingredientes.forEach(System.out::println);
    }

    abstract public void cocinar();

    abstract public void cortar();

    public void empaquetar() {
        System.out.println("Poniendo la pizza en una caja de empaque...");
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return "PizzaProducto{" +
                "masa='" + masa + '\'' +
                ", salsa='" + salsa + '\'' +
                ", ingredientes=" + ingredientes +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
