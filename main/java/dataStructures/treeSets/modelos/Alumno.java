package dataStructures.treeSets.modelos;

public class Alumno implements Comparable<Alumno> {

    private String nombre;
    private Integer nota;       //compareTo no se puede usar con primitivos por eso usamos la class wrapper

    public Alumno() {
    }

    public Alumno(String nombre, Integer nota) {
        this.nombre = nombre;
        this.nota = nota;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getNota() {
        return nota;
    }

    public void setNota(Integer nota) {
        this.nota = nota;
    }

    @Override
    public String toString() {
        return "nombre='" + nombre + '\'' +
                ", nota='" + nota + '\'';
    }

    @Override
    public int compareTo(Alumno alumno) {
//        if (this.nombre==null){
//            return 0;
//        }
//        return this.nombre.compareTo(alumno.nombre);
        if (this.nota.equals(alumno.nota)) {
            return 0;
        }
        if (this.nota > alumno.nota) {
            return 1;
        } else {
            return -1;
        }
    }
}
