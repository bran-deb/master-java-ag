package dataStructures.maps;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMappTest {
    public static void main(String[] args) {
        //No permite llaves repetidas
        Map<String, Object> persona = new HashMap<>();
        persona.put(null, "123");
        persona.put("nombre", "john");
        persona.put("Apellido", "Doe");
        persona.put("email", "john.doe@email.com");
        persona.put("edad", "30");

        Map<String, String> direccion = new HashMap<>();
        direccion.put("pais", "USA");
        direccion.put("estado", "california");
        direccion.put("ciudad", "santa barbara");
        direccion.put("calle", "one street");
        direccion.put("numero", "123");

        //HASHMAP ANIDADO
        persona.put("direccion", direccion);


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
        Collection<Object> valores = persona.values();
        valores.forEach(System.out::println);

        System.out.println("\n=====iterar keys=====");
        Set<String> llaves = persona.keySet();
        llaves.forEach(System.out::println);

        System.out.println("\n=====iterar keys & values=====");
        for (Map.Entry<String, Object> llaveValor : persona.entrySet()) {
            Object valor = llaveValor.getValue();
            if (valor instanceof Map) {//verifica si el dato es tipo map (direction)
                String nombrePersona = (String) persona.get("nombre");
                Map<String, String> direccionHashMap = (Map<String, String>) valor;//ya sabemos que valor es de tipo direction y accedemos a sus datos
                System.out.println("El pais de " + persona.get("nombre") + ": " + direccionHashMap.get("pais"));
                System.out.println("La ciudad de " + nombrePersona + ": " + direccionHashMap.get("ciudad"));
            } else {
                System.out.println(llaveValor.getKey() + "=>" + llaveValor.getValue());
            }
//            System.out.println("llaveValor sin if " + llaveValor);
        }

        System.out.println("\n=====iterar keys & values=====");
        for (String llave : persona.keySet()) {
            Object valor = persona.get(llave);
            if (valor instanceof Map) {
                String nombrePersona = (String) persona.get("nombre");
                Map<String, String> direccionMap = (Map<String, String>) valor;
                System.out.println("El pais de " + persona.get("nombre") + ": " + direccionMap.get("pais"));
                System.out.println("La ciudad de " + nombrePersona + ": " + direccionMap.get("ciudad"));
//                for (Map.Entry<String, String> parDir : direccionMap.entrySet()) {  //iterando el hashMap de direcciones
//                    System.out.println(parDir.getValue() + "=>" + parDir.getValue());
//                }

            } else {
                System.out.println(llave + "=>" + valor);
            }
        }

        System.out.println("\n=====iterar keys & values=====");
        persona.forEach((llave, valor) -> {
            System.out.println(llave + "=>" + valor);
        });

        System.out.println("\n=====otros métodos=====");
        System.out.println("total: " + persona.size());
        System.out.println("contiene elementos" + !persona.isEmpty());
        System.out.println("remplazar elemento");
        System.out.println(persona);
        persona.replace("nombre", "Andres");
        System.out.println(persona);


        System.out.println("\n=====usando direccion de hash anidado=====");
        Map<String, String> DireccionPersona = (Map<String, String>) persona.get("direccion");
        String pais = DireccionPersona.get("pais");
        String ciudad = DireccionPersona.get("ciudad");
        String barrio = DireccionPersona.getOrDefault("barrio", "La Playa");
        System.out.println("pais = " + pais);
        System.out.println("ciudad = " + ciudad);
        System.out.println("barrio = " + barrio);//usa valor por default
    }
}
