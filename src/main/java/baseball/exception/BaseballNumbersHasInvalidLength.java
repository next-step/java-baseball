package baseball.exception;

public class BaseballNumbersHasInvalidLength extends RuntimeException {
    public BaseballNumbersHasInvalidLength() {
        super("야구게임 숫자 모음에 유효하지 않은 길이입니다.");
    }

    public BaseballNumbersHasInvalidLength(String message) {
        super(message);
    }

    public BaseballNumbersHasInvalidLength(String message, Throwable cause) {
        super(message, cause);
    }

    public BaseballNumbersHasInvalidLength(Throwable cause) {
        super(cause);
    }

    protected BaseballNumbersHasInvalidLength(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
