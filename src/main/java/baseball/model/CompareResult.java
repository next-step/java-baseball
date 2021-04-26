package baseball.model;

public class CompareResult {
    private final int strikeCount;
    private final int ballCount;

    public CompareResult(int strikeCount, int ballCount) {
        this.strikeCount = strikeCount;
        this.ballCount = ballCount;
    }

    public int strikeCount() {
        return strikeCount;
    }

    public int ballCount() {
        return ballCount;
    }
}
