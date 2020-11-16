package com.coderhglee.game.exception;

public class ExceedAllowLengthException extends GameException {
    @Override
    public String getMessage() {
        return GameExceptionMessage.EXCEED_ALLOW_LENGTH_MESSAGE.message;
    }
}
