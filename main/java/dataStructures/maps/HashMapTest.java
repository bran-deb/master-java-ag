package dataStructures.maps;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMapTest {
    public static void main(String[] args) {
        //No permite llaves repetidas
        Map<String, String> persona = new HashMap<>();
        persona.put(null, "123");
        persona.put("nombre", "john");
        persona.put("Apellido", "Doe");
        persona.put("email", "john.doe@email.com");
        persona.put("edad", "30");
        System.out.println(persona);
        //obtiene los datos a través de sus key
        System.out.println("nombre: " + persona.get("nombre"));
        System.out.println("apellido: " + persona.get("apellido"));//si la llave no existe es null

        System.out.println("\n=====método remove=====");
        System.out.println(persona);
//        String datoEliminado = persona.remove("Apellido");
        boolean datoEliminado = persona.remove("Apellido", "Doe"); //por la key o (key & value)
        System.out.println("Se elimino correctamente: " + datoEliminado);
        System.out.println(persona);

        System.out.println("\n=====método containsKey=====");
        System.out.println(persona);
        boolean datoEliminado2 = persona.containsKey("Apellido");
        System.out.println("Se elimino correctamente = " + datoEliminado2);
        System.out.println(persona);

        System.out.println("\n=====método contains=====");
        datoEliminado2 = persona.containsValue("john.doe@email.com");
        System.out.println(persona);
        System.out.println("contiene el valor de john.doe@email.com");
        System.out.println("contiene el valor = " + datoEliminado2);

        System.out.println("\n=====iterar values=====");
        Collection<String> valores = persona.values();
        valores.forEach(System.out::println);

        System.out.println("\n=====iterar keys=====");
        Set<String> llaves = persona.keySet();
        llaves.forEach(System.out::println);

        System.out.println("\n=====iterar keys & values=====");
        for (Map.Entry<String, String> par : persona.entrySet()) {
            System.out.println(par.getKey() + "=>" + par.getValue());
        }

        System.out.println("\n=====iterar keys & values=====");
        for (String llave : persona.keySet()) {
            String valor = persona.get(llave);
            System.out.println(llave + "=>" + valor);
        }

        System.out.println("\n=====iterar keys & values=====");
        persona.forEach((llave, valor) -> {
            System.out.println(llave + "=>" + valor);
        });

        System.out.println("\n=====otros métodos=====");
        System.out.println("total: " +persona.size());
        System.out.println("contiene elementos"+!persona.isEmpty());
        System.out.println("remplazar elemento");
        System.out.println(persona);
        persona.replace("nombre", "Andres");
        System.out.println(persona);
    }
}
