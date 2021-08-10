package core.exception;

public class DriverInitException extends RuntimeException{

    public DriverInitException() {
    }

    public DriverInitException(String message) {
        super(message);
    }

    public DriverInitException(String message, Throwable cause) {
        super(message, cause);
    }
}
