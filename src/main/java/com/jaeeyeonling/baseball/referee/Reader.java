package com.jaeeyeonling.baseball.referee;

import com.jaeeyeonling.baseball.ball.Balls;

import static java.util.Objects.isNull;

public final class Reader {

    private final JudgeRule strikeRule;

    private final JudgeRule ballRule;

    private final JudgeRule missRule;

    private Reader(final JudgeRule strikeRule,
                   final JudgeRule ballRule,
                   final JudgeRule missRule) {
        this.strikeRule = strikeRule;
        this.ballRule = ballRule;
        this.missRule = missRule;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Reader basic() {
        return builder().build();
    }

    public Judge readout(final Balls balls,
                         final Balls other,
                         final int index) {
        if (strikeRule.judges(balls, other, index)) {
            return Judge.STRIKE;
        }
        if (ballRule.judges(balls, other, index)) {
            return Judge.BALL;
        }
        if (missRule.judges(balls, other, index)) {
            return Judge.MISS;
        }

        throw new UnsupportedJudgeException();
    }

    public static class Builder {

        private JudgeRule strikeRule;

        private JudgeRule ballRule;

        private JudgeRule missRule;

        private Builder() {
        }

        public Builder strikeRule(final JudgeRule rule) {
            this.strikeRule = rule;
            return this;
        }

        public Builder ballRule(final JudgeRule rule) {
            this.ballRule = rule;
            return this;
        }

        public Builder missRule(final JudgeRule rule) {
            this.missRule = rule;
            return this;
        }

        public JudgeRule getStrikeRule() {
            if (isNull(strikeRule)) {
                strikeRule = StrikeRule.getInstance();
            }

            return strikeRule;
        }

        public JudgeRule getBallRule() {
            if (isNull(ballRule)) {
                ballRule = BallRule.getInstance();
            }

            return ballRule;
        }

        public JudgeRule getMissRule() {
            if (isNull(missRule)) {
                missRule = MissRule.getInstance();
            }

            return missRule;
        }

        public Reader build() {
            return new Reader(getStrikeRule(), getBallRule(), getMissRule());
        }
    }
}
