package patronesDiseño.observer.corporacionEjemplo;

public class ObserverTest {
    public static void main(String[] args) {

        Corporation google = new Corporation("Google", 1000D);

        google.addObserver((observable, object) -> System.out.println("John: " + observable));

        google.addObserver((observable, object) -> System.out.println("Andres: " + observable));

        google.addObserver((observable, object) -> {
            System.out.println("Maria: " + ((Corporation) observable).getNombre() +
                    "Nuevo precio $" +
                    ((Corporation) observable).getPrecio());
        });

        google.updatePrecio(2000D);
    }
}
