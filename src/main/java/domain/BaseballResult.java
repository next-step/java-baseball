package domain;

public class BaseballResult {

    private static final String MESSAGE_STRIKE = " 스트라이크";
    private static final String MESSAGE_BALL = " 볼";
    private static final String MESSAGE_NOTHING = "낫싱!";

    private int strikeCount;
    private int ballCount;
    private boolean isWin = false;

    public void ball() {
        this.ballCount++;
    }

    public void strike() {
        this.strikeCount++;

        if (strikeCount > 2) {
            isWin = true;
        }
    }

    public boolean isEndGame() {
        return isWin;
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public int getBallCount() {
        return ballCount;
    }

    public boolean isFoul() {
        return strikeCount == 0 && ballCount == 0;
    }

    public String resultScreen() {
        if (isFoul()) {
            return MESSAGE_NOTHING;
        }
        return makeResultMessage();
    }

    private String makeResultMessage() {
        StringBuilder sb = new StringBuilder();

        checkCountAndAddMessage(sb, strikeCount, MESSAGE_STRIKE);
        checkCountAndAddMessage(sb, ballCount, MESSAGE_BALL);

        return sb.toString();
    }

    private void checkCountAndAddMessage(StringBuilder sb, int ballCount, String message) {
        if (ballCount > 0) {
            sb.append(ballCount).append(message);
        }
    }
}
