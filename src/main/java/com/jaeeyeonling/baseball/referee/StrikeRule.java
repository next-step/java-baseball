package com.jaeeyeonling.baseball.referee;

import com.jaeeyeonling.baseball.ball.Balls;

public enum StrikeRule implements JudgeRule {

    INSTANCE;

    private StrikeRule() {
    }

    public static JudgeRule getInstance() {
        return INSTANCE;
    }

    @Override
    public boolean judges(final Balls balls,
                          final Balls other,
                          final int index) {
        return balls.match(other, index);
    }
}
