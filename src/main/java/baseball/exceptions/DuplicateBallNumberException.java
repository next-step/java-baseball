package baseball.exceptions;

public class DuplicateBallNumberException extends RuntimeException {
    public static final String DEFAULT_MESSAGE = "야구게임의 숫자는 서로 다른 숫자여야 합니다.";

    public DuplicateBallNumberException() {
        super(DEFAULT_MESSAGE);
    }

    public DuplicateBallNumberException(String message) {
        super(message);
    }
}
