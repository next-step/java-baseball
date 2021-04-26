public class Result {
    private int strikeCount;
    private int ballCount;

    public Result() {
        this.strikeCount = 0;
        this.ballCount = 0;
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public int getBallCount() {
        return ballCount;
    }

    public void increaseStrikeCount() {
        strikeCount += 1;
    }

    public void increaseBallCount() {
        ballCount += 1;
    }

    public boolean isNothing() {
        return strikeCount == 0 && ballCount == 0;
    }
}