package domain;

import java.util.Objects;

public class Score {
    private static final String MAX_COUNT_ERROR = "스트라이크와 볼의 합은 최대 3 입니다.";
    private static final int MAX_COUNT = 3;

    private final int strike;
    private final int ball;

    public Score(int strike, int ball) {
        validMaxCount(strike + ball);
        this.strike = strike;
        this.ball = ball;
    }

    private void validMaxCount(int count) {
        if (count > MAX_COUNT) {
            throw new IllegalArgumentException(MAX_COUNT_ERROR);
        }
    }

    public int strike() {
        return strike;
    }

    public int ball() {
        return ball;
    }

    public boolean isFinish() {
        return strike == MAX_COUNT;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Score score = (Score) o;
        return strike == score.strike && ball == score.ball;
    }

    @Override
    public int hashCode() {
        return Objects.hash(strike, ball);
    }
}
