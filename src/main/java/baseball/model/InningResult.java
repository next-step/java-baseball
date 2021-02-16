package baseball.model;

import baseball.model.shot.Shot;

import java.util.Map;

public class InningResult {
    private static final int FINISH_CONDITION = 3;

    private final StringBuilder result = new StringBuilder();
    private boolean isFinish = false;

    public InningResult(final Map<Shot, Integer> shots) {
        parsingResult(shots);
        parsingIsFinish(shots);
    }

    public String getMessage() {
        return result.toString();
    }

    public boolean isFinish() {
        return isFinish;
    }

    private void parsingResult(final Map<Shot, Integer> shots) {
        final String resultFormat = "%d%s";

        final int ball = shots.getOrDefault(Shot.BALL, 0);
        final int strike = shots.getOrDefault(Shot.STRIKE, 0);
        final int out = shots.getOrDefault(Shot.OUT, 0);

        if (ball > 0) {
            result.append(String.format(resultFormat, ball, Shot.BALL.toString())).append(" ");
        }
        if (strike > 0) {
            result.append(String.format(resultFormat, strike, Shot.STRIKE.toString())).append(" ");
        }
        if (out == 3) {
            result.append(Shot.NOTHING);
        }
    }

    private void parsingIsFinish(final Map<Shot, Integer> shots) {
        isFinish = (shots.getOrDefault(Shot.STRIKE, 0) == FINISH_CONDITION);
    }
}