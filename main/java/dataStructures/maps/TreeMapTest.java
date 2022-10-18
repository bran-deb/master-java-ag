package dataStructures.maps;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class TreeMapTest {
    public static void main(String[] args) {
        //se ordena por las key (se personaliza con compareTo o comparable)
        //No permite llaves repetidas (solo muestra el último)
        Map<String, Object> persona = new TreeMap<>((a, b) -> b.compareTo(a));  //ordena ascendentemente
//        Map<String,Object> persona = new TreeMap<>(Comparator.comparing(String::length).reversed());   //ordena por el largo del string (grande a pequeño)
//        persona.put(null, "123");     //no pueden existir elementos null en la key
        persona.put("nombre", "john");
        persona.put("Apellido", "Doe");
        persona.put("email", "john.doe@email.com");
        persona.put("edad", "30");

        Map<String, String> direccion = new TreeMap<>(Comparator.reverseOrder());   //ordena ascendentemente
        direccion.put("pais", "USA");
        direccion.put("estado", "california");
        direccion.put("ciudad", "santa barbara");
        direccion.put("calle", "one street");
        direccion.put("numero", "123");

        //HASHMAP ANIDADO
        persona.put("direccion", direccion);

        System.out.println(persona);
    }
}
