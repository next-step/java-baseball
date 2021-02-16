package domain;

import java.util.Arrays;
import java.util.List;

public enum Result {
    BALL_ONLY,
    STRIKE_ONLY,
    BALL_AND_STRIKE,
    NOTHING,
    OUT;

    private static final int NOTHING_CNT = 0;
    private static final int FULL_CNT = 3;

    private static final String NOTHING_NAME = "낫싱";
    private static final String BALL_NAME = "볼";
    private static final String STRIKE_NAME = "스트라이크";

    // TODO : Change with streams
    public static Result of(int strike, int ball) {
        if (strike == FULL_CNT) return OUT;
        if (strike == NOTHING_CNT && ball == NOTHING_CNT) return NOTHING;
        if (strike == NOTHING_CNT) return BALL_ONLY;
        if (ball == NOTHING_CNT) return Result.STRIKE_ONLY;
        if (strike != NOTHING_CNT && ball != NOTHING_CNT) return BALL_AND_STRIKE;

        throw new RuntimeException("Unreachable point");
    }

    public List<String> format(int strike, int ball) {
        if (this == Result.NOTHING) return Arrays.asList(NOTHING_NAME);
        if (this == Result.BALL_ONLY) return Arrays.asList(ball + BALL_NAME);
        if (this == Result.STRIKE_ONLY) return Arrays.asList(strike + STRIKE_NAME);
        if (this == Result.BALL_AND_STRIKE) return Arrays.asList(ball + BALL_NAME, strike + STRIKE_NAME);
        if (this == Result.OUT) return Arrays.asList(FULL_CNT + STRIKE_NAME);

        throw new RuntimeException("Unreachable point");
    }
}
