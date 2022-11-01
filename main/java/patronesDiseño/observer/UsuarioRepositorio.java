package patronesDiseño.observer;

import java.util.ArrayList;
import java.util.List;

public class UsuarioRepositorio extends Observable {

    private final List<String> repositorio;

    public UsuarioRepositorio() {
        repositorio = new ArrayList<>();
    }

    public void crearUsuario(String usuario) {
        repositorio.add(usuario);
        notifyObservers(usuario);
    }
}
