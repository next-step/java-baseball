package baseball.exception;

public class BaseballNumberInvalidFormatException extends RuntimeException {
    public BaseballNumberInvalidFormatException() {
        super("야구게임에 유효하지 않은 형식 입니다. - 정수만 입력 가능");
    }

    public BaseballNumberInvalidFormatException(String message) {
        super(message);
    }

    public BaseballNumberInvalidFormatException(String message, Throwable cause) {
        super(message, cause);
    }

    public BaseballNumberInvalidFormatException(Throwable cause) {
        super(cause);
    }

    protected BaseballNumberInvalidFormatException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
