package patronesDiseño.decorator.ejemploCafe.decorators;

import patronesDiseño.decorator.ejemploCafe.Configurable;

public class CremaDecorador extends CafeDecorator {

    public CremaDecorador(Configurable coffee) {
        super(coffee);
    }

    @Override
    public float getPrecioBase() {
        return coffee.getPrecioBase() + 15f;
    }

    @Override
    public String getIngredientes() {
        return coffee.getIngredientes() + ", crema";
    }
}
