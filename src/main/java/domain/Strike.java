package domain;

public class Strike {

    private static final int ALL_MATCHING = 3;
    private static final int NOT_MATCHING = 0;

    private int strikeCount;

    public Strike(int strike) {
        this.strikeCount = strike;
    }

    public boolean isAllMatching() {
        return strikeCount == ALL_MATCHING;
    }

    public boolean isExistMatching() {
        return strikeCount > NOT_MATCHING;
    }

    public int getStrikeCount() {
        return strikeCount;
    }

}
