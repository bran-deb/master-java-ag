package patronesDiseño.abstractFactory.producto.NewYork;

import patronesDiseño.abstractFactory.producto.PizzaProducto;

public class PizzaNuevaYorkItaliana extends PizzaProducto {

    public PizzaNuevaYorkItaliana() {
        super();
        nombre = "Pizza Italiana New York";
        masa = "Masa gruesa";
        salsa = "Salsa de tomate Italiana";
        ingredientes.add("Queso Mozzarella");
        ingredientes.add("Jamón");
        ingredientes.add("Aceitunas");
        ingredientes.add("Espinaca");
        ingredientes.add("Berenjenas");
    }

    @Override
    public void cocinar() {
        System.out.println("Cocinando por 30 min a 120^C");
    }

    @Override
    public void cortar() {
        System.out.println("Cortando la pizza en triángulos grandes");
    }
}
