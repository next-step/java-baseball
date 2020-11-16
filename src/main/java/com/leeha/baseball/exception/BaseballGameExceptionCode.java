package com.leeha.baseball.exception;

public enum BaseballGameExceptionCode {

    INVALID_CAPACITY_EXCEPTION("Invalid capacity exception"),
    INVALID_MINIMUM_OR_MAXIMUM_EXCEPTION("Invalid minimum or maximum exception");

    private final String message;

    BaseballGameExceptionCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}