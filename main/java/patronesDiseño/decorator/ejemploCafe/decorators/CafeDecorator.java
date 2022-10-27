package patronesDiseño.decorator.ejemploCafe.decorators;

import patronesDiseño.decorator.ejemploCafe.Configurable;

abstract public class CafeDecorator implements Configurable {
    //se crea una variable del tipo de interface que implementa con el objeto
    protected Configurable coffee;

    public CafeDecorator(Configurable coffee) {
        this.coffee = coffee;
    }
}
