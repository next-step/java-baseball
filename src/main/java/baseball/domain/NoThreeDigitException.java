package baseball.domain;

public class NoThreeDigitException extends IllegalArgumentException {
    public NoThreeDigitException(String message) {
        super(message);
    }
}
