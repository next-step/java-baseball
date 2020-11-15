package com.jaeeyeonling.baseball.ball;

import com.jaeeyeonling.baseball.BaseballException;

public final class BallOutOfRangeException extends BaseballException {

    static final String MESSAGE = "PositiveDigit 은 " + Ball.MIN_VALUE + " ~ " +
            Ball.MAX_VALUE + " 사이의 값으로만 생성할 수 있습니다. (입력 값: '%s')";

    public BallOutOfRangeException(final int input) {
        super(String.format(MESSAGE, input));
    }
}
