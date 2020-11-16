package com.leeha.baseball.exception;

public class InvalidMinimumOrMaximumException extends RuntimeException {

    public InvalidMinimumOrMaximumException(BaseballGameExceptionCode code) {
        super(code.getMessage());
    }
}
