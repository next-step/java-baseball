package domain;

public class CountByMatchType {
    private final MatchType matchType;
    private int count;

    private CountByMatchType(MatchType matchType, int count) {
        this.matchType = matchType;
        this.count = count;
    }

    public static CountByMatchType init(MatchType matchType) {
        return new CountByMatchType(matchType, 0);
    }

    public boolean isMatchType(MatchType matchType) {
        return this.matchType == matchType;
    }

    public int getCount() {
        return count;
    }

    public void increaseCount() {
        count++;
    }
}
