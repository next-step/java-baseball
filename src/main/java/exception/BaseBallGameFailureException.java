package exception;

public class BaseBallGameFailureException extends RuntimeException {
    public BaseBallGameFailureException(ErrorCode errorCode) {
        super(String.format("code: '%s' message: '%s'", errorCode.getCode(), errorCode.getMessage()));
    }

    private BaseBallGameFailureException(String message) {
        super(message);
    }

    private BaseBallGameFailureException(String message, Throwable cause) {
        super(message, cause);
    }

    private BaseBallGameFailureException(Throwable cause) {
        super(cause);
    }

    private BaseBallGameFailureException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
