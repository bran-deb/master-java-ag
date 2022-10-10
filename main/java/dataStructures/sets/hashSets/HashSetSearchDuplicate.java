package dataStructures.sets.hashSets;

import java.util.HashSet;
import java.util.Set;

public class HashSetSearchDuplicate {
    public static void main(String[] args) {

        String[] peces = {"Convina", "Lenguado", "Pejerey", "Robalo", "Atun", "Lenguado","Sardina","Sardina"};

        Set<String> pecesSinRepetidos = new HashSet<>();
        Set<String> pecesRepetidos = new HashSet<>();

        for (String pez : peces) {
            if (!pecesSinRepetidos.add(pez)) {
                pecesRepetidos.add(pez);
                System.out.println("Elemento duplicado = " + pez);
            }
        }
        System.out.println("peces sin repetidos" + pecesSinRepetidos);
        System.out.println("peces repetidos" + pecesRepetidos);
        //remove todos los duplicados
        pecesSinRepetidos.removeAll(pecesRepetidos);
        System.out.println("eliminar peces repetidos"+pecesSinRepetidos);
    }
}
