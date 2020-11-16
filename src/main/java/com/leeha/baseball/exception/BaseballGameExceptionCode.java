package com.leeha.baseball.exception;

public enum BaseballGameExceptionCode {

    CAPACITY_OUT_OF_RANGE_EXCEPTION("ball generate failed because capacity is out of range");

    private final String message;

    BaseballGameExceptionCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}