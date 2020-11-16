package com.coderhglee.game.exception;

public class ContainSameNumberException extends GameException {
    @Override
    public String getMessage() {
        return GameExceptionMessage.CONTAIN_SAME_NUMBER_MESSAGE.message;
    }
}
