package dataStructures.sets.hashSets;

import dataStructures.modelos.Alumno;

import java.util.*;

public class testHashSetEquals {

    public static void main(String[] args) {
        //compara dependiendo de como se implementa (Equals y hashCode)
        Set<Alumno> alumnos = new HashSet<>();
//        List<Alumno> alumnos = new ArrayList<>();
        alumnos.add(new Alumno("juan", 5));
        alumnos.add(new Alumno("luci", 6));
        alumnos.add(new Alumno("cata", 4));
        alumnos.add(new Alumno("andy", 2));
        alumnos.add(new Alumno("andy", 3));
        System.out.println("\nalumnos = " + alumnos);

        //ITERATORS PARA UN SET
        System.out.println("\niterando con for each");
        for (Alumno alumno : alumnos) {
            System.out.println(alumno.getNombre());
        }
        //iterator y while
        System.out.println("\niterando con iterator y while");
        Iterator<Alumno> iterator = alumnos.iterator();
        while (iterator.hasNext()) {
            Alumno alumno = iterator.next();
            System.out.println(alumno.getNombre());
        }
        //foreach
        System.out.println("\ncon stream foreach");
        alumnos.forEach(alumno -> System.out.println(alumno.getNombre()));

        //classic for utilizado en list porque tiene acceso a su id
        //for (int i = 0; i < alumnos.size(); i++) {
        //    Alumno alumno = alumnos.get(i);
        //    System.out.println(alumno.getNombre());
        //}
    }
}
