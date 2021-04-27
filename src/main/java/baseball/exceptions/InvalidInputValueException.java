package baseball.exceptions;

public class InvalidInputValueException extends RuntimeException {
    public static final String DEFAULT_MESSAGE = "입력하신 값은 유효하지 않습니다.";

    public InvalidInputValueException() {
        super(DEFAULT_MESSAGE);
    }

    public InvalidInputValueException(String message) {
        super(message);
    }
}
