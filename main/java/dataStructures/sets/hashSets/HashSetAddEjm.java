package dataStructures.sets.hashSets;

import java.util.*;

public class HashSetAddEjm {
    public static void main(String[] args) {

        Set<String> hash = new HashSet<>();
        hash.add("uno");
        hash.add("dos");
        hash.add("tres");
        hash.add("cuatro");
        hash.add("cinco");
        System.out.println(hash);

        boolean addDuplicado = hash.add("uno");
        System.out.println("Permite add duplicado = " + addDuplicado);
    }
}
