package baseball.exception;

import static baseball.exception.message.ErrorMessage.BASEBALL_NUMBERS_HAS_DUPLICATION_EXCEPTION_MASSAGE;

public class BaseballNumbersHasDuplicationException extends RuntimeException {
    public BaseballNumbersHasDuplicationException() {
        super(BASEBALL_NUMBERS_HAS_DUPLICATION_EXCEPTION_MASSAGE.getMessage());
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
