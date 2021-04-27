package baseball;

public class BaseballResult {

    private static final String MESSAGE_STRIKE = "STRIKE";
    private static final String MESSAGE_BALL = "BALL";
    private static final String MESSAGE_NOTHING = "NOTHING";

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

    public String resultPrint() {
        StringBuilder sb = new StringBuilder();
        if (strikeCount > 0) {
            sb.append(strikeCount).append(MESSAGE_STRIKE);
        }
        if (ballCount > 0) {
            sb.append(ballCount).append(MESSAGE_BALL);
        }
        if (strikeCount == 0 && ballCount == 0) {
            return MESSAGE_NOTHING;
        }
        return sb.toString();
    }
}