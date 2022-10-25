package patronesDiseño.abstractFactory.factory;

import patronesDiseño.abstractFactory.Exceptions.InvalidTypeException;
import patronesDiseño.abstractFactory.producto.NewYork.PizzaNuevaYorkItaliana;
import patronesDiseño.abstractFactory.producto.NewYork.PizzaNuevaYorkPeperoni;
import patronesDiseño.abstractFactory.producto.NewYork.PizzaNuevaYorkVegetariana;
import patronesDiseño.abstractFactory.producto.PizzaProducto;
import patronesDiseño.abstractFactory.types.Tipo;

public class PizzeriaNewYorkFactory extends PizzeriaZonaAbstractFactory {

    @Override
    PizzaProducto crearPizza(Tipo tipo) {
        return switch (tipo) {
            case VEGETARIANA -> new PizzaNuevaYorkVegetariana();
            case PEPERONI -> new PizzaNuevaYorkPeperoni();
            case ITALIANA -> new PizzaNuevaYorkItaliana();
            default -> throw new InvalidTypeException("Unexpected value: " + tipo);
        };
    }
}
