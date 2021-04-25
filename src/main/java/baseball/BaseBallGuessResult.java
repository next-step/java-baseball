package baseball;

public class BaseBallGuessResult {
    private int strikeCount;
    private int ballCount;
    private boolean isFourBall;

    public int getStrikeCount() {
        return strikeCount;
    }

    public void setStrikeCount(int strikeCount) {
        this.strikeCount = strikeCount;
    }

    public int getBallCount() {
        return ballCount;
    }

    public void setBallCount(int ballCount) {
        this.ballCount = ballCount;
    }

    public boolean isFourBall() {
        return isFourBall;
    }

    public void setIsFourBall(boolean isFourBall) {
        this.isFourBall = isFourBall;
    }
}
