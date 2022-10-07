package dataStructures.treeSets.modelos;

import java.util.Set;
import java.util.TreeSet;

public class testSetComparable {

    public static void main(String[] args) {
        //agregado de comparable a alumnos para poder usar treeSet y ordenar por nombre
        Set<Alumno> alumnos = new TreeSet<>((a, b) -> b.getNombre().compareTo(a.getNombre()));
        alumnos.add(new Alumno("juan", 5));
        alumnos.add(new Alumno("luci", 6));
        alumnos.add(new Alumno("cata", 4));
        alumnos.add(new Alumno("andy", 2));
        alumnos.add(new Alumno("andy", 2));

        System.out.println("alumnos = " + alumnos);
    }
}
