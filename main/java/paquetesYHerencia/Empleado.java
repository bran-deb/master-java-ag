package paquetesYHerencia;

public class Empleado extends Persona {

    private final int idEmpleado;
    private double sueldo;
    private static int contadorEmpleado;
    
    public Empleado(String nombre, double sueldo){
        super(nombre);
        this.idEmpleado = ++contadorEmpleado;//cada que crea una nueva instancia cuanta +1
        this.sueldo = sueldo;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public static int getContadorEmpleado() {
        return contadorEmpleado;
    }

    @Override
    public String toString() {
        return super.toString() + "paquetesYHerencia.Empleado{" + "idEmpleado=" + idEmpleado
                + ", sueldo=" + sueldo + '}';
    }
    
}
