package com.bistros.game.cli;

import com.bistros.game.domain.exception.BaseBallException;

public class InvalidInputException extends BaseBallException {
    public InvalidInputException() {
    }

    public InvalidInputException(String message) {
        super(message);
    }
}
