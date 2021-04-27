package baseball.exception;

public final class InvalidNumbersException extends IllegalArgumentException {

    public InvalidNumbersException(final String input) {
        super(input);
    }
}
