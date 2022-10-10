package dataStructures.lists;

import dataStructures.modelos.Alumno;

import java.util.ArrayList;
import java.util.List;

public class ArrayListTest {

    public static void main(String[] args) {

        List<Alumno> alumnos = new ArrayList<>();
        System.out.println(alumnos + ", size = " + alumnos.size());
        System.out.println("esta vacía = " + alumnos.isEmpty());
        alumnos.add(new Alumno("juan", 5));
        alumnos.add(new Alumno("luci", 6));
        alumnos.add(new Alumno("cata", 4));
        alumnos.set(2, new Alumno("andy", 7));           //set modifica en la position
        alumnos.add(1, new Alumno("andy", 2));     //agrega en la position

        System.out.println(alumnos + ", size = " + alumnos.size());
        System.out.println("esta vacía = " + alumnos.isEmpty());

        alumnos.remove(0);
        System.out.println(alumnos);
        alumnos.remove(new Alumno("luci", 6));   //utiliza la implementation de equals (nombre o nota)
        System.out.println(alumnos);

        Object[] a = alumnos.toArray();
        for (Object o : a) {
            System.out.println("array" + o);
        }
    }
}
