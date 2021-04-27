package baseball.domain.exception;

public class NoAllowNumberException extends IllegalArgumentException {
    public NoAllowNumberException(String message) {
        super(message);
    }
}
