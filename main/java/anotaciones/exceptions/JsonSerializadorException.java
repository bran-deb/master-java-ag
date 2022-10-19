package anotaciones.exceptions;

public class JsonSerializadorException extends RuntimeException {

    public JsonSerializadorException(String message) {
        super(message);
    }

    public JsonSerializadorException(String message, Throwable cause) {
        super(message, cause);
    }
}
