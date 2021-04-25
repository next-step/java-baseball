package baseball.domain;

import java.util.Objects;

public class PitchResult {
    private static final int STRIKE_COUNT = 3;
    private static final int NO_COUNT = 0;

    private final int strikeCount;
    private final int ballCount;

    private PitchResult(int strikeCount, int ballCount) {
        validate(strikeCount, ballCount);
        this.strikeCount = strikeCount;
        this.ballCount = ballCount;
    }

    public static PitchResult of(int strikeCount, int ballCount) {
        return new PitchResult(strikeCount, ballCount);
    }

    private void validate(int strikeCount, int ballCount) {
        if (strikeCount + ballCount > STRIKE_COUNT) {
            throw new IllegalArgumentException("유효하지 않은 결과입니다");
        }
    }

    public boolean isFinished() {
        return this.strikeCount == STRIKE_COUNT;
    }

    public boolean isExistsStrike() {
        return this.strikeCount != NO_COUNT;
    }

    public boolean isExistsBall() {
        return this.ballCount != NO_COUNT;
    }

    public boolean isNothing() {
        return  !this.isExistsStrike() && !this.isExistsBall();
    }

    public int strike() {
        return this.strikeCount;
    }

    public int ball() {
        return this.ballCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        PitchResult that = (PitchResult)o;
        return strikeCount == that.strikeCount && ballCount == that.ballCount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(strikeCount, ballCount);
    }
}
