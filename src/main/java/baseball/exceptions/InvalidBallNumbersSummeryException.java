package baseball.exceptions;

public class InvalidBallNumbersSummeryException extends RuntimeException {
    public static final String DEFAULT_MESSAGE = "야구 게임 결과가 올바르지 않습니다.";

    public InvalidBallNumbersSummeryException() {
        super(DEFAULT_MESSAGE);
    }

    public InvalidBallNumbersSummeryException(String message) {
        super(message);
    }
}
