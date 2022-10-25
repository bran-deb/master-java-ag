package patronesDiseño.abstractFactory.factory;

import patronesDiseño.abstractFactory.producto.PizzaProducto;
import patronesDiseño.abstractFactory.types.Tipo;

abstract public class PizzeriaZonaAbstractFactory {

    public PizzaProducto ordenarPizza(Tipo tipo) {
        PizzaProducto pizza = crearPizza(tipo);
        System.out.println("\n-----fabricando la pizza " + pizza.getNombre() + "-----");
        pizza.preparar();
        pizza.cocinar();
        pizza.cortar();
        pizza.empaquetar();
        return pizza;
    }

    abstract PizzaProducto crearPizza(Tipo tipo);
}
