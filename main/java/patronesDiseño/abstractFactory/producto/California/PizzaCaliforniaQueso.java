package patronesDiseño.abstractFactory.producto.California;

import patronesDiseño.abstractFactory.producto.PizzaProducto;

public class PizzaCaliforniaQueso extends PizzaProducto {

    public PizzaCaliforniaQueso() {
        super();
        nombre = "Pizza california Queso";
        masa = "Masa a la piedra delgada";
        salsa = "Salsa de tomate rúcula";
        ingredientes.add("Extra queso Mozzarella");
        ingredientes.add("Cebolla");
        ingredientes.add("Queso azul");
    }

    @Override
    public void cocinar() {
        System.out.println("Cocinando 35 min a 100^C");
    }

    @Override
    public void cortar() {
        System.out.println("Cortando la pizza en pequeños triángulos");
    }
}
