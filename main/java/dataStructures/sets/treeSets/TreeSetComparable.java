package dataStructures.sets.treeSets;

import dataStructures.modelos.Alumno;

import java.util.Set;
import java.util.TreeSet;

import static java.util.Comparator.comparing;

public class TreeSetComparable {

    public static void main(String[] args) {
        //compara dependiendo de como se implementa él (compareTo)
        //agregado de comparable a alumnos para poder usar treeSet y ordenar por nombre
//        Set<Alumno> alumnos = new TreeSet<>((a, b) -> b.getNombre().compareTo(a.getNombre()));
        Set<Alumno> alumnos = new TreeSet<>(comparing(Alumno::getNombre).reversed());//java 8
        alumnos.add(new Alumno("juan", 5));
        alumnos.add(new Alumno("luci", 6));
        alumnos.add(new Alumno("cata", 4));
        alumnos.add(new Alumno("andy", 2));
        alumnos.add(new Alumno("holy", 2));

        System.out.println("alumnos = " + alumnos);
    }
}
