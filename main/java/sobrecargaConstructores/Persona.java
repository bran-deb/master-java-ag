package sobrecargaConstructores;

public class Persona {
    private int IdPersona;
    private String nombre;
    private int edad;
    private static int contadorPersonas;
    
    private Persona(){
        this.IdPersona = ++contadorPersonas;
    }
    
    public Persona(String nombre, int edad){
        this();
        this.nombre = nombre;
        this.edad = edad;
    }

    public int getIdPersona() {
        return IdPersona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public static int getContadorPersonas() {
        return contadorPersonas;
    }

    @Override
    public String toString() {
        return "paquetesYHerencia.Persona{" + "IdPersona=" + IdPersona + ", nombre=" + nombre + ", edad=" + edad + '}';
    }
    
}
