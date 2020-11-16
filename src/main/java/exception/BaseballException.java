package exception;

public class BaseballException extends RuntimeException {
    public BaseballException(ExceptionStatus status) {
        super(status.getMessage());
    }
}
