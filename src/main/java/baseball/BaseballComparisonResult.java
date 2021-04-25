package baseball;

public class BaseballComparisonResult {

    public int strikeCount;
    public int ballCount;

    public BaseballComparisonResult(int strikeCount, int ballCount) {
        this.strikeCount = strikeCount;
        this.ballCount = ballCount;
    }

    public boolean hasStrikeCount() {
        return strikeCount > 0 ? true : false;
    }

    public boolean hasBallCount() {
        return ballCount > 0 ? true : false;
    }

    public boolean hasBothCount() {
        return strikeCount > 0 && ballCount > 0 ? true : false;
    }

}
