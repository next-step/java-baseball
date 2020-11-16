package com.leeha.baseball.exception;

public class MinimumAndMaximumRangeInvalidException extends RuntimeException {

    public MinimumAndMaximumRangeInvalidException(BaseballGameExceptionCode code) {
        super(code.getMessage());
    }
}