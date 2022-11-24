package testsJUnit5.exceptions;

public class DineroInsuficienteException extends RuntimeException {
    public DineroInsuficienteException(String message) {
        super(message);
    }

    public DineroInsuficienteException(String message, Throwable cause) {
        super(message, cause);
    }
}
