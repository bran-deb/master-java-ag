package patronesDiseño.observer;

public class ObserverTest2 {
    public static void main(String[] args) {

        UsuarioRepositorio repositorio = new UsuarioRepositorio();
        repositorio.addObserver((observable, usuario) -> System.out.println("Enviando un email al usuario " + usuario));
        repositorio.addObserver((observable, usuario) -> System.out.println("Enviando un email al administrador"));
        repositorio.addObserver((observable, usuario) -> System.out.println("Guardando info del usuario " + usuario + " en el logs"));
        repositorio.crearUsuario("Andres");
    }
}
