package numberBaseball.exception;

public class NotThreeDigitException extends IllegalArgumentException {
    public NotThreeDigitException(String message) {
        super(message);
    }
}
