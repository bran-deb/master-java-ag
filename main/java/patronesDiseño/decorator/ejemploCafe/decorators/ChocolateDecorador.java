package patronesDiseño.decorator.ejemploCafe.decorators;

import patronesDiseño.decorator.ejemploCafe.Configurable;

public class ChocolateDecorador extends CafeDecorator {

    public ChocolateDecorador(Configurable coffee) {
        super(coffee);
    }

    @Override
    public float getPrecioBase() {
        return coffee.getPrecioBase() + 15f;
    }

    @Override
    public String getIngredientes() {
        return coffee.getIngredientes() + ", chocolate";
    }
}
