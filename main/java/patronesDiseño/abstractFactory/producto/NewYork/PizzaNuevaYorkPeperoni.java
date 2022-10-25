package patronesDiseño.abstractFactory.producto.NewYork;

import patronesDiseño.abstractFactory.producto.PizzaProducto;

public class PizzaNuevaYorkPeperoni extends PizzaProducto {

    public PizzaNuevaYorkPeperoni() {
        super();
        nombre = "Pizza Peperoni New York";
        masa = "Masa delgada a la piedra";
        salsa = "Salsa de tomate";
        ingredientes.add("Queso mozzarella");
        ingredientes.add("Extra peperoni");
        ingredientes.add("Aceitunas");
    }

    @Override
    public void cocinar() {
        System.out.println("Cocinando por 40 min. a 90^C");
    }

    @Override
    public void cortar() {
        System.out.println("Cortando la pizza en triángulos");
    }
}
