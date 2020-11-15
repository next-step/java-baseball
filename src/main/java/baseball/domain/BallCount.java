package baseball.domain;

public class BallCount {

    private static final int THREE_STRIKE_COUNT = 3;
    private static final int NOTHING_COUNT = 0;

    private int strikeCount = 0;
    private int ballCount = 0;

    public void addStrikeCount() {
        this.strikeCount++;
    }

    public void addBallCount() {
        this.ballCount++;
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public int getBallCount() {
        return ballCount;
    }

    public boolean isNothing() {
        return strikeCount + ballCount == NOTHING_COUNT;
    }

    public boolean isThreeStrike() {
        return strikeCount == THREE_STRIKE_COUNT;
    }
}
