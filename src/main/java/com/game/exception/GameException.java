package com.game.exception;

import com.game.code.ErrorCode;

public class GameException extends RuntimeException {

    public GameException(ErrorCode errorCode) {
        super(errorCode.getMessage());
    }
}
