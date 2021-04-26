package baseball.exception;

import static baseball.exception.message.ErrorMessage.BASEBALL_NUMBERS_HAS_INVALID_LENGTH_EXCEPTION_MASSAGE;

public class BaseballNumbersHasInvalidLength extends RuntimeException {
    public BaseballNumbersHasInvalidLength() {
        super(BASEBALL_NUMBERS_HAS_INVALID_LENGTH_EXCEPTION_MASSAGE.getMessage());
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
