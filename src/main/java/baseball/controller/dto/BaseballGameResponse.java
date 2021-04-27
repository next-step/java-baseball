package baseball.controller.dto;

public class BaseballGameResponse {

    private final int strikeCount;
    private final int ballCount;
    private final boolean isNothing;
    private final boolean isFinished;

    public BaseballGameResponse(int strikeCount, int ballCount, boolean isNothing, boolean isFinished) {
        this.strikeCount = strikeCount;
        this.ballCount = ballCount;
        this.isNothing = isNothing;
        this.isFinished = isFinished;
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public int getBallCount() {
        return ballCount;
    }

    public boolean isNothing() {
        return isNothing;
    }

    public boolean isFinished() {
        return isFinished;
    }
}
