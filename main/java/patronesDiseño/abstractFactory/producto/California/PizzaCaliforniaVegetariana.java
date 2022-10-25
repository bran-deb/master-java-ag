package patronesDiseño.abstractFactory.producto.California;

import patronesDiseño.abstractFactory.producto.PizzaProducto;

public class PizzaCaliforniaVegetariana extends PizzaProducto {

    public PizzaCaliforniaVegetariana() {
        super();
        nombre = "Pizza California Vegetariana";
        masa = "Masa delgada Light";
        salsa = "Salsa BBQ Light";
        ingredientes.add("Queso Mozzarella");
        ingredientes.add("Aceitunas");
        ingredientes.add("Espinaca");
        ingredientes.add("Cebollas");
        ingredientes.add("Berenjena");

    }

    @Override
    public void cocinar() {
        System.out.println("Cocinado por 20 min a 100^C");
    }

    @Override
    public void cortar() {
        System.out.println("Cortar la pizza en rebanadas rectangulares");
    }
}
