package baseball;

public class BaseballResult {

    private int strikeCount;
    private int ballCount;
    private String judgementMessage;
    private boolean isRightAnswer;

    public BaseballResult(int strikeCount, int ballCount, String judgementMessage, boolean isRightAnswer) {
        this.strikeCount = strikeCount;
        this.ballCount = ballCount;
        this.judgementMessage = judgementMessage;
        this.isRightAnswer = isRightAnswer;
    }

    public String getJudgementMessage() {
        return judgementMessage;
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public int getBallCount() {
        return ballCount;
    }

    public boolean isRightAnswer() {
        return isRightAnswer;
    }
}
