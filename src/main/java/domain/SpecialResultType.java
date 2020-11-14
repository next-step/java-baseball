package domain;

public enum SpecialResultType implements Result {
    NOTHING(0, 0),
    THREE_STRIKE(3, 0);

    private final int strikeCount;
    private final int ballCount;

    SpecialResultType(int strikeCount, int ballCount) {
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
