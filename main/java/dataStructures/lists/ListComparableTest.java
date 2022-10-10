package dataStructures.lists;

import dataStructures.modelos.Alumno;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ListComparableTest {

    public static void main(String[] args) {

        List<Alumno> alumnos = new ArrayList<>();
        alumnos.add(new Alumno("juan", 5));
        alumnos.add(new Alumno("luci", 6));
        alumnos.add(new Alumno("cata", 4));
        alumnos.add(new Alumno("andy", 2));
        alumnos.add(new Alumno("andy", 7));
        //la sobrecarga se hace en el método short y no en la definición new ArrayList<>()
        //se aplica por defecto compareTo implementado en alumno (varía dependiendo la implementation)
        //Collections.sort(alumnos, (a, b) -> a.getNombre().compareTo(b.getNombre()));
        //alumnos.sort((a, b) -> a.getNombre().compareTo(b.getNombre()));
        alumnos.sort(Comparator.comparing(Alumno::getNombre).reversed());
        System.out.println("\nalumnos = " + alumnos);

        //foreach
        System.out.println("\ncon stream foreach");
        alumnos.forEach(System.out::println);

    }
}
