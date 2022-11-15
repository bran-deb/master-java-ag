package JDBC.JDBCPoolTransacciones.exceptions;

public class PersistantException extends RuntimeException {
    public PersistantException(String message) {
        super(message);
    }

    public PersistantException(String message, Throwable cause) {
        super(message, cause);
    }
}
