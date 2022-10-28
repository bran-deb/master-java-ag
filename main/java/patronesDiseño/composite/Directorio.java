package patronesDiseño.composite;

import java.util.ArrayList;
import java.util.List;

public class Directorio extends Componente {
    //la lista de hijos puede ser ce archivos o directorios
    private final List<Componente> hijos;

    public Directorio(String nombre) {
        super(nombre);
        this.hijos = new ArrayList<>();
    }

    //recibe un componente para recibir el tipo más genérico
    public void addComponente(Componente componente) {
        hijos.add(componente);
    }

    public void removeComponente(Componente componente) {
        hijos.remove(componente);
    }

    @Override
    public String mostrar() {
        StringBuilder sb = new StringBuilder();
        sb.append(nombre)
                .append("/")
                .append("\n");

        for (Componente hijo : this.hijos) {
            sb.append(hijo.mostrar());

            if (hijo instanceof Archivo) {
                sb.append("\n");
            }
        }
        return sb.toString();
    }

    @Override
    public String mostrar(int nivel) {
        StringBuilder sb = new StringBuilder("\t".repeat(nivel));
        sb.append(nombre)
                .append("/")
                .append("\n");

        for (Componente hijo : this.hijos) {
            sb.append(hijo.mostrar(nivel + 1));

            if (hijo instanceof Archivo) {
                sb.append("\n");
            }
        }
        return sb.toString();
    }

    @Override
    public boolean buscar(String nombre) {
        if (this.nombre.equalsIgnoreCase(nombre)) {
            return true;
        }
        return hijos.stream().anyMatch(hijo -> hijo.buscar(nombre));
/*        for (Componente hijo : hijos) {
//            if (hijo.buscar(nombre)) {
//                return true;
//            }
//        }
//        return false;
*/
    }
}
