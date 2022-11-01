package patronesDiseño.observer;

public class Corporation extends Observable {

    private final String nombre;
    private double precio;

    public Corporation(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void updatePrecio(double precio) {
        this.precio = precio;
        notifyObservers();
    }

    @Override
    public String toString() {
        return getNombre() +
                "Nuevo precio $" +
                getPrecio();
    }
}
