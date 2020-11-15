package baseballgame.dto;

public class CompareResult {
    private final boolean pass;
    private final int strikeCount;
    private final int ballCount;

    public CompareResult(int strikeCount, int ballCount) {
        this.strikeCount = strikeCount;
        this.ballCount = ballCount;

        final int SCORE_LIMIT = 3;
        pass = this.strikeCount == SCORE_LIMIT;
    }

    public boolean isPass() {
        return pass;
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public int getBallCount() {
        return ballCount;
    }
}
