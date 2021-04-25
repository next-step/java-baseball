package baseball.exception;

public class BaseballNumberInvalidRangeException extends RuntimeException{
    public BaseballNumberInvalidRangeException() {
        super("야구게임에 유효하지 않은 숫자 범위 입니다.");
    }

    public BaseballNumberInvalidRangeException(String message) {
        super(message);
    }

    public BaseballNumberInvalidRangeException(String message, Throwable cause) {
        super(message, cause);
    }

    public BaseballNumberInvalidRangeException(Throwable cause) {
        super(cause);
    }

    protected BaseballNumberInvalidRangeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
