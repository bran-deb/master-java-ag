package patronesDiseño.singleton;

public class SingletonTest {
    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {
            ConnexionDB conexionDB = ConnexionDB.getInstance();
            System.out.println("connexionDB = " + conexionDB);
        }

        ConnexionDB connexionDB2 = ConnexionDB.getInstance();
        ConnexionDB connexionDB3 = ConnexionDB.getInstance();

        System.out.println("Son la misma instancia: " + (connexionDB2 == connexionDB3));
    }
}
