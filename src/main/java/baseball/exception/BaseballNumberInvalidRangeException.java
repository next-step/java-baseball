package baseball.exception;

import static baseball.exception.message.ErrorMessage.BASEBALL_NUMBER_INVALID_RANGE_EXCEPTION_MASSAGE;

public class BaseballNumberInvalidRangeException extends RuntimeException {
    public BaseballNumberInvalidRangeException() {
        super(BASEBALL_NUMBER_INVALID_RANGE_EXCEPTION_MASSAGE.getMessage());
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
