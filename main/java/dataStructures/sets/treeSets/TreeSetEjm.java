package dataStructures.sets.treeSets;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class TreeSetEjm {
    public static void main(String[] args) {
        //ordenar de forma ascendente  con comparator
        Set<String> treeSet = new TreeSet<>(Comparator.reverseOrder());
        //Set<String> treeSet = new TreeSet<>(Comparator.naturalOrder());
        treeSet.add("uno");
        treeSet.add("dos");
        treeSet.add("tres");
        treeSet.add("cuatro");
        treeSet.add("cinco");
        //imprime alfabéticamente
        System.out.println("\ntreeSet = " + treeSet);

        //ordenar de forma ascendente con funciones anónimas
        Set<Integer> numTreeSet = new TreeSet<>((a, b) -> b.compareTo(a));
        numTreeSet.add(5);
        numTreeSet.add(2);
        numTreeSet.add(1);
        numTreeSet.add(3);
        numTreeSet.add(4);
        //imprime por valor de unicode
        System.out.println("\nnumTreeSet = " + numTreeSet);
    }
}
