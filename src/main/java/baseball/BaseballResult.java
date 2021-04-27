package baseball;

public class BaseballResult {



    private int strikeCount;
    private int ballCount;
    private boolean isFinished = false;

    public void initial() {
        this.ballCount = 0;
        this.strikeCount = 0;
    }

    public void isBall() {
        this.ballCount++;
    }

    public void isStrike() {
        this.strikeCount++;
        if (strikeCount > 2) {
            isFinished = true;
        }
    }

    public boolean isNothing() {
        return strikeCount == 0 && ballCount == 0;
    }

    public boolean isEndGame() {
        return isFinished;
    }

    public int getBallCount() {
        return ballCount;
    }

    public int getStrikeCount() {
        return strikeCount;
    }

}