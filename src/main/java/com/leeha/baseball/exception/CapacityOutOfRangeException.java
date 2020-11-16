package com.leeha.baseball.exception;

public class CapacityOutOfRangeException extends RuntimeException {

    public CapacityOutOfRangeException(BaseballGameExceptionCode code) {
        super(code.getMessage());
    }
}