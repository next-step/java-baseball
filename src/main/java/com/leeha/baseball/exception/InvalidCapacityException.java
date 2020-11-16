package com.leeha.baseball.exception;

public class InvalidCapacityException extends RuntimeException {

    public InvalidCapacityException(BaseballGameExceptionCode code) {
        super(code.getMessage());
    }
}
