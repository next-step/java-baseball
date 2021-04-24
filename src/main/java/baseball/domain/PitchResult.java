package baseball.domain;

public class PitchResult {
    private static final int STRIKE_COUNT = 3;

    private final int strikeCount;
    private final int ballCount;

    private PitchResult(int strikeCount, int ballCount) {
        this.strikeCount = strikeCount;
        this.ballCount = ballCount;
    }

    public static PitchResult of(int strikeCount, int ballCount) {
        return new PitchResult(strikeCount, ballCount);
    }

    public boolean isFinished() {
        return this.strikeCount == STRIKE_COUNT;
    }
}
