package patronesDiseño.decorator.ejemploCafe.decorators;

import patronesDiseño.decorator.ejemploCafe.Configurable;

public class LecheDecorador extends CafeDecorator {

    public LecheDecorador(Configurable coffee) {
        super(coffee);
    }

    @Override
    public float getPrecioBase() {
        return coffee.getPrecioBase() + 5f;
    }

    @Override
    public String getIngredientes() {
        return coffee.getIngredientes() + ", leche";
    }
}
