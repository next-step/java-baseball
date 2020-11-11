package domain;

import domain.exceptions.InvalidBaseballResultParameterException;

import java.util.Objects;

public class BaseballResult {
    private final int ballCount;
    private final int strikeCount;
    private final boolean fourBall;

    BaseballResult(int ballCount, int strikeCount, boolean fourBall) {
        validate(ballCount, strikeCount, fourBall);
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

    private void validate(int ballCount, int strikeCount, boolean fourBall) {
        validateFourBall(ballCount, strikeCount, fourBall);
        validateNegativeNumber(ballCount, strikeCount);
        validateMaxCount(ballCount, strikeCount);
    }

    private void validateFourBall(int ballCount, int strikeCount, boolean fourBall) {
        if (!fourBall) {
            return;
        }
        if (ballCount == 0 && strikeCount == 0) {
            return;
        }
        throw new InvalidBaseballResultParameterException("FourBall cannot be Ball or Strike");
    }

    private void validateNegativeNumber(int ballCount, int strikeCount) {
        if (ballCount < 0 || strikeCount <0) {
            throw new InvalidBaseballResultParameterException("BaseballResult not allowed negative number");
        }
    }

    private void validateMaxCount(int ballCount, int strikeCount) {
        if ((ballCount + strikeCount) > 3) {
            throw new InvalidBaseballResultParameterException("Over max count sum of ball and strike(max: 3)");
        }
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
