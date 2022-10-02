package sobrecargaConstructores;

public class Empleado extends Persona{
    
    private double sueldo;
    public Empleado(String nombre, int edad){
        super(nombre, edad);
    }
    
    public Empleado(String nombre, int edad, int sueldo){
        this(nombre, edad);
        this.sueldo = sueldo;
    }

    @Override
    public String toString() {
        return super.toString() + "paquetesYHerencia.Empleado{" + "sueldo=" + sueldo + '}';
    }
    
}
