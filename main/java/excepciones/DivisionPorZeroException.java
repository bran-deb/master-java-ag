package excepciones;
//checked
public class DivisionPorZeroException extends Exception {

    public DivisionPorZeroException(String message) {
        super(message);
    }

    public DivisionPorZeroException(String message, Throwable cause) {
        super(message, cause);
    }
}
