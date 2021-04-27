package com.bistros.game.domain.exception;

public class BaseBallException extends RuntimeException {
    public BaseBallException() {
    }

    public BaseBallException(String message) {
        super(message);
    }

    public BaseBallException(String message, Throwable cause) {
        super(message, cause);
    }

    public BaseBallException(Throwable cause) {
        super(cause);
    }

    public BaseBallException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
