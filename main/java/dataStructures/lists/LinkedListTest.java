package dataStructures.lists;

import dataStructures.modelos.Alumno;

import java.util.LinkedList;

public class LinkedListTest {

    public static void main(String[] args) {
        //usar tipo LinkedList para acceder a sus métodos (List solo tiene los methods iguales)
        LinkedList<Alumno> alumnos = new LinkedList<>();
        System.out.println(alumnos + ", size = " + alumnos.size());
        System.out.println("esta vacía = " + alumnos.isEmpty());
        alumnos.add(new Alumno("juan", 5));
        alumnos.add(new Alumno("luci", 6));
        alumnos.add(new Alumno("cata", 4));
        alumnos.add(new Alumno("andy", 7));
        alumnos.add(new Alumno("andy", 2));
        System.out.println(alumnos + ", size = " + alumnos.size());
        System.out.println("esta vacía = " + alumnos.isEmpty());


        System.out.println("\nAdd primer & ultimo alumno");
        System.out.println("alumnos = " + alumnos);
        alumnos.addFirst(new Alumno("Zeus", 5));
        alumnos.addLast(new Alumno("Pepito", 1));
        System.out.println("alumnos = " + alumnos);

        System.out.println("\nobtener primer & ultimo alumno");
        System.out.println(alumnos.getFirst());
//        System.out.println(alumnos.peekFirst());//lanza un null
        System.out.println(alumnos.getLast());

        System.out.println("\nDelete primer & ultimo alumno");
        System.out.println("alumnos = " + alumnos);
        //eliminamos y guardamos para usar después
        Alumno alumnoEliminado = alumnos.removeFirst();
//        Alumno alumnoEliminado = alumnos.pop();
//        Alumno alumnoEliminado = alumnos.pollFirst();//retorna null
        System.out.println("alumnoEliminado = " + alumnoEliminado);

        alumnoEliminado = alumnos.removeLast();
//        alumnoEliminado = alumnos.pollLast();
        System.out.println("alumnoEliminado = " + alumnoEliminado);
        System.out.println("alumnos = " + alumnos);

        System.out.println("\nDelete por alumno & index");
        System.out.println("alumnos = " + alumnos);
        //remove por alumno
        alumnos.remove(new Alumno("andy", 2));
        System.out.println("alumnos = " + alumnos);
        //remove por indice
        alumnos.remove(3);
        System.out.println("alumnos = " + alumnos);

        System.out.println("\nModificar por index");
        System.out.println("alumnos = " + alumnos);
        alumnos.set(0, new Alumno("pedri", 6));
        System.out.println("alumnos = " + alumnos);

    }
}
