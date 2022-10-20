package patronesDiseño.singleton;

//  PATRON CREACIONAL
public class ConnexionDB {

    private static ConnexionDB instance;

    private ConnexionDB() {
        System.out.println("DB Connection");
    }

    public static ConnexionDB getInstance() {

        if (ConnexionDB.instance == null) {
            return ConnexionDB.instance = new ConnexionDB();
        }
        return ConnexionDB.instance;
    }
}
