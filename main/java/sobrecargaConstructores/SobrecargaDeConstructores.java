package sobrecargaConstructores;

public class SobrecargaDeConstructores {
    public static void main(String[] args) {
        Persona persona1 = new Persona("Juan",25);
        System.out.println("paquetesYHerencia.Persona" + persona1);
        
        Empleado empleado1 = new Empleado("Carla", 30, 4000);
        System.out.println("empleado1 = " + empleado1);
    }
}
