package baseball.exception;

import static baseball.exception.message.ErrorMessage.BASEBALL_NUMBER_INVALID_FORMAT_EXCEPTION_MASSAGE;

public class BaseballNumberInvalidFormatException extends RuntimeException {
    public BaseballNumberInvalidFormatException() {
        super(BASEBALL_NUMBER_INVALID_FORMAT_EXCEPTION_MASSAGE.getMessage());
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
