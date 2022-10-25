package patronesDiseño.abstractFactory.producto.California;

import patronesDiseño.abstractFactory.producto.PizzaProducto;

public class PizzaCaliforniaPeperoni extends PizzaProducto {

    public PizzaCaliforniaPeperoni() {
        super();
        nombre = "Pizza California Peperoni";
        masa = "Masa a la piedra gruesa";
        salsa = "Peperoni";
        ingredientes.add("Peperoni");
        ingredientes.add("Extra mozzarella");
        ingredientes.add("Aceitunas");
    }

    @Override
    public void cocinar() {
        System.out.println("Cocinar 50 min a 55^C");
    }

    @Override
    public void cortar() {
        System.out.println("Cortando la pizza en pequeños rectángulos");
    }
}
