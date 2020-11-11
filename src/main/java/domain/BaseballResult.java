package domain;

import java.util.Objects;

public class BaseballResult {
    private final int ballCount;
    private final int strikeCount;
    private final boolean fourBall;

    BaseballResult(int ballCount, int strikeCount, boolean fourBall) {
        this.ballCount = ballCount;
        this.strikeCount = strikeCount;
        this.fourBall = fourBall;
    }

    public static BaseballResult makeFourBall() {
        return new BaseballResult(0,0 , true);
    }

    public static BaseballResult of(int ballCount, int strikeCount) {
        return new BaseballResult(ballCount, strikeCount, false);
    }

    public boolean isFourBall() {
        return fourBall;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseballResult that = (BaseballResult) o;
        return ballCount == that.ballCount &&
                strikeCount == that.strikeCount &&
                fourBall == that.fourBall;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ballCount, strikeCount, fourBall);
    }
}
