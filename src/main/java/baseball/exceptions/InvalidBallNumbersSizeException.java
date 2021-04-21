package baseball.exceptions;

public class InvalidBallNumbersSizeException extends RuntimeException {
    public static final String DEFAULT_MESSAGE = "야구게임에 필요한 야구숫자는 3개여야 합니다.";

    public InvalidBallNumbersSizeException() {
        super(DEFAULT_MESSAGE);
    }

    public InvalidBallNumbersSizeException(String message) {
        super(message);
    }
}
