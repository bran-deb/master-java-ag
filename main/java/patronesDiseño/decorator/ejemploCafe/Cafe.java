package patronesDiseño.decorator.ejemploCafe;

public class Cafe implements Configurable {

    private final float precio;
    private final String ingredientes;

    public Cafe(float precio, String ingredientes) {
        this.precio = precio;
        this.ingredientes = ingredientes;
    }

    @Override
    public float getPrecioBase() {
        return this.precio;
    }

    @Override
    public String getIngredientes() {
        return this.ingredientes;
    }
}
