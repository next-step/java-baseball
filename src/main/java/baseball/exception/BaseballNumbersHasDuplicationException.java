package baseball.exception;

public class BaseballNumbersHasDuplicationException extends RuntimeException {
    public BaseballNumbersHasDuplicationException() {
        super("야구게임 숫자 모음은 중복된 수를 가질 수 없습니다.");
    }

    public BaseballNumbersHasDuplicationException(String message) {
        super(message);
    }

    public BaseballNumbersHasDuplicationException(String message, Throwable cause) {
        super(message, cause);
    }

    public BaseballNumbersHasDuplicationException(Throwable cause) {
        super(cause);
    }

    protected BaseballNumbersHasDuplicationException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
