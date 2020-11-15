package com.jaeeyeonling.baseball.referee;

import com.jaeeyeonling.baseball.ball.Balls;

public final class MissRule extends FilteredRule {

    private MissRule(final JudgeRule... excludeRules) {
        super(excludeRules);
    }

    public static JudgeRule getInstance() {
        return MissRule.LazyHolder.INSTANCE;
    }

    @Override
    boolean filteredJudge(final Balls balls,
                          final Balls other,
                          final int index) {
        return true;
    }

    private static final class LazyHolder {

        private static final JudgeRule INSTANCE = new MissRule(StrikeRule.getInstance(),
                BallRule.getInstance());
    }
}
