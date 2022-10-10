package dataStructures.maps;

import java.util.HashMap;
import java.util.Map;

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
    }
}
