package baseball.exceptions;

public class InvalidBallNumberException extends RuntimeException {
    public static final String DEFAULT_MESSAGE = "야구공의 숫자는 1~9만 유효합니다.";

    public InvalidBallNumberException() {
        super(DEFAULT_MESSAGE);
    }

    public InvalidBallNumberException(String message) {
        super(message);
    }
}
