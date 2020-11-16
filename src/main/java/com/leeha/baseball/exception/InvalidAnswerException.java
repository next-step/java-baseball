package com.leeha.baseball.exception;

public class InvalidAnswerException extends RuntimeException {

    public InvalidAnswerException(BaseballGameExceptionCode invalidAnswerException) {
        super(invalidAnswerException.getMessage());
    }
}
