public class Result {
    private static final int ZERO = 0;

    private int strikeCount;
    private int ballCount;
    private boolean success;

    public Result() {
        this.strikeCount = ZERO;
        this.ballCount = ZERO;
        this.success = false;
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

    public void doSuccess() {
        success = true;
    }

    public boolean isSuccess() {
        return success;
    }

    public boolean isNothing() {
        return strikeCount == ZERO && ballCount == ZERO;
    }
}