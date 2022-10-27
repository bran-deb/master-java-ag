package patronesDiseño.decorator.ejemploCafe;

import patronesDiseño.decorator.ejemploCafe.decorators.ChocolateDecorador;
import patronesDiseño.decorator.ejemploCafe.decorators.CremaDecorador;
import patronesDiseño.decorator.ejemploCafe.decorators.LecheDecorador;

public class testCafe {
    public static void main(String[] args) {

        //Cafe cafe = new Cafe(15, "canela y chocolate");
        Configurable cafe = new Cafe(15, "cafe capuchino");
        System.out.println("cafe ingredientes = " + cafe.getIngredientes());
        System.out.println("cafe precio = " + cafe.getPrecioBase());

        //ChocolateDecorador cafeChocolate = new ChocolateDecorador(cafe);
        Configurable cafeChocolate = new ChocolateDecorador(cafe);
        System.out.println("cafe ingredientes = " + cafeChocolate.getIngredientes());
        System.out.println("cafe precio = " + cafeChocolate.getPrecioBase());

        //CremaDecorador cafeCrema = new CremaDecorador(cafeChocolate);
        Configurable cafeCrema = new CremaDecorador(cafe);
        System.out.println("cafe ingredientes = " + cafeCrema.getIngredientes());
        System.out.println("cafe precio = " + cafeCrema.getPrecioBase());

        //LecheDecorador cafeLeche = new LecheDecorador(cafeCrema);
        Configurable cafeLeche = new LecheDecorador(cafeCrema);
        System.out.println("cafe ingredientes = " + cafeLeche.getIngredientes());
        System.out.println("cafe precio = " + cafeLeche.getPrecioBase());
    }
}
