package domain;

public class Hint implements Result {
    private final int strikeCount;
    private final int ballCount;

    public Hint(int strikeCount, int ballCount) {
        this.strikeCount = strikeCount;
        this.ballCount = ballCount;
    }

    @Override
    public int getStrikeCount() {
        return strikeCount;
    }

    @Override
    public int getBallCount() {
        return ballCount;
    }

}
