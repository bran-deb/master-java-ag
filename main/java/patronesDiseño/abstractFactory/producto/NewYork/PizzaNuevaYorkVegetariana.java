package patronesDiseño.abstractFactory.producto.NewYork;

import patronesDiseño.abstractFactory.producto.PizzaProducto;

public class PizzaNuevaYorkVegetariana extends PizzaProducto {

    public PizzaNuevaYorkVegetariana() {
        super();
        nombre = "Pizza vegetariana Nueva York";
        masa = "Masa integral vegana";
        salsa = "Salsa de tomate";
        ingredientes.add("Queso vegano");
        ingredientes.add("Tomate");
        ingredientes.add("Aceitunas");
        ingredientes.add("Espinacas");
        ingredientes.add("Berenjenas");
    }


    @Override
    public void cocinar() {
        System.out.println("Cocinando por 25 min a 150^C");
    }

    @Override
    public void cortar() {
        System.out.println("Cortando la pizza en rebanadas cuadradas.");
    }
}
