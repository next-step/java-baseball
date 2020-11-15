package com.jaeeyeonling.baseball;

public abstract class BaseballException extends RuntimeException {

    private static final String MESSAGE = "알 수 없는 에러입니다.";

    public BaseballException() {
        this(MESSAGE);
    }

    public BaseballException(final String message) {
        super(message);
    }
}
