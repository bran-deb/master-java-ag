package genericos;

import pooInterfaces.modelo.Cliente;
import pooInterfaces.modelo.ClientePremium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestGenerics {
    public static void main(String[] args) {

        List<Cliente> clientes = new ArrayList<>();
        clientes.add(new Cliente("Brand", "Padilla"));


        Cliente[] clientesArray = {new Cliente("Andres", "Guzman"), new Cliente("Jose", "Guzman")};
        Integer[] enterosArray = {1, 2, 3};
        ClientePremium[] clientesPremiumArray = {new ClientePremium("Josh", "Guzman"), new ClientePremium("Hans", "Guzman")};

        List<Cliente> clientes1 = fromArrayToList(clientesArray);
        List<Integer> numero1 = fromArrayToList(enterosArray);
        List<ClientePremium> clientesPremiums = fromArrayToList(clientesPremiumArray);

        List<String> nombres = fromArrayToList(new String[]{"Andres", "Pepe", "Lucy", "bea", "John"}, enterosArray);

        System.out.println("============");
        clientes1.forEach(System.out::println);
        System.out.println("============");
        numero1.forEach(System.out::println);
        System.out.println("============");
        clientesPremiums.forEach(System.out::println);
        //dos parámetros generics
        System.out.println("============");
        nombres.forEach(System.out::println);

        System.out.println("============");
        imprimirClientes(clientes);
        imprimirClientes(clientes1);
        imprimirClientes(clientesPremiums);

        System.out.println("Maximo de 1,9 y 4 es : "+maximo(1,9,4));
        System.out.println("Maximo de 3.9, 11.6 y 7.78 es : "+maximo(3.9, 11.6 , 7.78));
        System.out.println("Maximo de zanahoria, arandanos y manzana es : "+maximo("zanahoria", "arandanos" ,"manzana"));
    }

    //tipo T sin restricciones
    public static <T> List<T> fromArrayToList(T[] array) {
        return Arrays.asList(array);
    }

    //Tipo T con restricciones only Numbers
    public static <T extends Number> List<T> fromArrayToList(T[] array) {
        return Arrays.asList(array);
    }

    //Tipo T con restricciones solo Clientes y sus subClases e Interface comparable de tipo <T>
    public static <T extends Cliente & Comparable<T>> List<T> fromArrayToList(T[] array) {
        return Arrays.asList(array);
    }

    //Tipo T con restricciones solo ClientesPremium(subClase de cliente)
    public static <T extends ClientePremium> List<T> fromArrayToList(T[] array) {
        return Arrays.asList(array);
    }

    //Tipo T con dos parameters tipo <T,G>
    public static <T, G> List<T> fromArrayToList(T[] arrayToList, G[] ArrayToPrint) {
//        Arrays.stream(ArrayToPrint).forEach(System.out::println);
        for (G elemento : ArrayToPrint) {
            System.out.println(elemento);
        }
        return Arrays.asList(arrayToList);
    }

    //comodín
    public static void imprimirClientes(List<? extends Cliente> clientes) {
        clientes.forEach(System.out::println);
    }
    //retorna un T que es el maximo de tres tipos T
    public static <T extends Comparable<T>> T maximo(T a, T b, T c) {
        T max = a;
        if (b.compareTo(max) > 0) {
            max = b;
        }
        if (c.compareTo(max) > 0) {
            max = c;
        }
        return max;
    }
}
