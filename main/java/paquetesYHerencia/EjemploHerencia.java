package paquetesYHerencia;

import java.util.Date;


public class EjemploHerencia {

    public static void main(String[] args) {
        Empleado empleado1 = new Empleado("Juan", 50000);
        System.out.println(""+empleado1);
        empleado1.setEdad(28);
        empleado1.setGenero('M');
        empleado1.setDireccion("Lomas");
        System.out.println(empleado1);
    
        Cliente cliente1 = new Cliente(new Date(),true);
        cliente1.setNombre("Pedro");
        cliente1.setEdad(40);
        cliente1.setDireccion("Los angeles");
        System.out.println(cliente1);
        
        Cliente cliente2 = new Cliente(new Date(),true);
        cliente2.setNombre("Pedro");
        cliente2.setEdad(40);
        cliente2.setDireccion("Los angeles");
        System.out.println(cliente2);
        
    }
}
