package Interfaces.modelo;

import java.util.ArrayList;
import java.util.List;

public class Curriculo extends Hoja implements Imprimible {

    private Persona autor;
    private String carrera;
    private List<String> experiencias;

    public Curriculo(String contenido, Persona autor, String carrera) {
        super(contenido);
        this.autor = autor;
        this.carrera = carrera;
        this.experiencias = new ArrayList<>();
    }

    public Curriculo addExperiencia(String exp) {
        experiencias.add(exp);
        return this;
    }

    @Override
    public String imprimir() {
        StringBuilder sb = new StringBuilder("Nombre: ");
        sb.append(autor).append("\n")
                .append("Resumen: ").append(this.contenido)
                .append("\n").append("Profesion: ")
                .append(this.carrera).append("\n")
                .append("Experiencias: \n");
        for (String exp : this.experiencias) {
            sb.append("- ").append(exp).append("\n");
        }
        return sb.toString();
    }
}
