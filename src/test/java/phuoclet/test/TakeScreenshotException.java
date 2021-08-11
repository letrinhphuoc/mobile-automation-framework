package phuoclet.test;

public class TakeScreenshotException extends RuntimeException {

    public TakeScreenshotException() {
    }

    public TakeScreenshotException(String message) {
        super(message);
    }

    public TakeScreenshotException(String message, Throwable cause) {
        super(message, cause);
    }
}
