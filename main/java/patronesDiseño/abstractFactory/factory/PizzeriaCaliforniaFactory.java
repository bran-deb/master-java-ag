package patronesDiseño.abstractFactory.factory;

import patronesDiseño.abstractFactory.Exceptions.InvalidTypeException;
import patronesDiseño.abstractFactory.producto.California.PizzaCaliforniaPeperoni;
import patronesDiseño.abstractFactory.producto.California.PizzaCaliforniaQueso;
import patronesDiseño.abstractFactory.producto.California.PizzaCaliforniaVegetariana;
import patronesDiseño.abstractFactory.producto.PizzaProducto;
import patronesDiseño.abstractFactory.types.Tipo;

public class PizzeriaCaliforniaFactory extends PizzeriaZonaAbstractFactory {

    @Override
    PizzaProducto crearPizza(Tipo tipo) {
        return switch (tipo) {
            case VEGETARIANA -> new PizzaCaliforniaVegetariana();
            case PEPERONI -> new PizzaCaliforniaPeperoni();
            case QUESO -> new PizzaCaliforniaQueso();
            default -> throw new InvalidTypeException("Unexpected value: " + tipo);
        };
    }
}
