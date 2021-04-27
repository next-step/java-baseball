package baseball.domain.exception;

public class NoThreeDigitException extends IllegalArgumentException {
    public NoThreeDigitException(String message) {
        super(message);
    }
}
