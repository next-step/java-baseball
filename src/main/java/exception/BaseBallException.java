package exception;

public class BaseBallException extends RuntimeException {
    public BaseBallException(ExceptionMessage message) {
        super(message.getMessage());
    }
}
