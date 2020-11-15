package com.jaeeyeonling.baseball.referee;

import com.jaeeyeonling.baseball.ball.Balls;

public final class BallRule extends FilteredRule {

    private BallRule(final JudgeRule excludeRules) {
        super(excludeRules);
    }

    public static JudgeRule getInstance() {
        return LazyHolder.INSTANCE;
    }

    @Override
    boolean filteredJudge(final Balls balls,
                          final Balls other,
                          final int index) {
        final var ball = other.get(index);
        return balls.contains(ball);
    }

    private static final class LazyHolder {

        private static final JudgeRule INSTANCE = new BallRule(StrikeRule.getInstance());
    }
}
