package ejemploPalabraFinal.palabraFinal;

import static ejemploPalabraFinal.palabraFinal.ClaseFinal.VAR_PERSONA;

public class EjemploPalabraFinal1 {
    public static void main(String[] args) {
        // variable final
        // ClaseFinal.VAR_PRIMITIVO = 20;

        // modificar la referencia de objeto
        // ClaseFinal.VAR_PERSONA = new paquetesYHerencia.Persona;

        ClaseFinal.VAR_PERSONA.setNombre("Juan");
        System.out.println("claseFinal = " + VAR_PERSONA.getNombre());

        ClaseFinal.VAR_PERSONA.setNombre("Pedro");
        System.out.println("ClaseFinal = " + VAR_PERSONA.getNombre());
    }

}
