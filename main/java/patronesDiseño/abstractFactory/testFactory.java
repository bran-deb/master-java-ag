package patronesDiseño.abstractFactory;

import patronesDiseño.abstractFactory.factory.PizzeriaCaliforniaFactory;
import patronesDiseño.abstractFactory.factory.PizzeriaNewYorkFactory;
import patronesDiseño.abstractFactory.factory.PizzeriaZonaAbstractFactory;
import patronesDiseño.abstractFactory.producto.PizzaProducto;
import patronesDiseño.abstractFactory.types.Tipo;

//  PATRON CREACIONAL
public class testFactory {
    public static void main(String[] args) {

        PizzeriaZonaAbstractFactory newYork = new PizzeriaNewYorkFactory();
        PizzeriaZonaAbstractFactory california = new PizzeriaCaliforniaFactory();


        PizzaProducto pizza = california.ordenarPizza(Tipo.QUESO);
        System.out.println("Bruce ordena la pizza "+pizza.getNombre());

        PizzaProducto pizzaNY = newYork.ordenarPizza(Tipo.VEGETARIANA);
        System.out.println("Jhon ordena la pizza "+pizzaNY.getNombre());

        pizzaNY = newYork.ordenarPizza(Tipo.QUESO);
        System.out.println("Jhon ordena la pizza "+pizzaNY.getNombre());
    }
}
