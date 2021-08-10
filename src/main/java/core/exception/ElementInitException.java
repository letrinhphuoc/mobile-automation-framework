package core.exception;

public class ElementInitException extends RuntimeException {

    public ElementInitException() {
    }

    public ElementInitException(String message) {
        super(message);
    }

    public ElementInitException(String message, Throwable cause) {
        super(message, cause);
    }
}
