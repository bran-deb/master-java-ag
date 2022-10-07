package dataStructures.hashSets;

import dataStructures.modelos.Alumno;

import java.util.HashSet;
import java.util.Set;

public class testHashSetEquals {

    public static void main(String[] args) {
        //compara dependiendo de como se implementa (Equals y hashCode)
        Set<Alumno> alumnos = new HashSet<>();
        alumnos.add(new Alumno("juan", 5));
        alumnos.add(new Alumno("luci", 6));
        alumnos.add(new Alumno("cata", 4));
        alumnos.add(new Alumno("andy", 2));
        alumnos.add(new Alumno("andy", 3));

        System.out.println("alumnos = " + alumnos);
    }
}
