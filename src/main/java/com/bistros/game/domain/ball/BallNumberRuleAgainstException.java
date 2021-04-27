package com.bistros.game.domain.ball;

import com.bistros.game.domain.exception.BaseBallException;

public class BallNumberRuleAgainstException extends BaseBallException {
    public BallNumberRuleAgainstException(String message) {
        super(message);
    }
}
