public class Result {
    private static final int ZERO = 0;

    private int strikeCount;
    private int ballCount;

    public Result() {
        this.strikeCount = ZERO;
        this.ballCount = ZERO;
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public int getBallCount() {
        return ballCount;
    }

    public void increaseStrikeCount() {
        strikeCount++;
    }

    public void increaseBallCount() {
        ballCount++;
    }
    }

    public boolean isNothing() {
        return strikeCount == ZERO && ballCount == ZERO;
    }
}