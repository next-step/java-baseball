package domain;

public class GuessResult {
    private final MatchTypeCounts matchTypeCounts;

    private GuessResult(MatchTypeCounts matchTypeCounts) {
        this.matchTypeCounts = matchTypeCounts;
    }

    public static GuessResult init() {
        return new GuessResult(MatchTypeCounts.init());
    }

    public int getStrikeCount() {
        return matchTypeCounts.getCountOfMatchType(MatchType.STRIKE);
    }

    public int getBallCount() {
        return matchTypeCounts.getCountOfMatchType(MatchType.BALL);
    }

    public boolean isThreeStrike() {
        return matchTypeCounts.getCountOfMatchType(MatchType.STRIKE) == 3;
    }

    public boolean isNothing() {
        return matchTypeCounts.getCountOfMatchType(MatchType.STRIKE) == 0
                && matchTypeCounts.getCountOfMatchType(MatchType.BALL) == 0;
    }

    public void increaseMatchCount(MatchType matchType) {
        if (matchType == MatchType.NO_MATCH) {
            return;
        }
        matchTypeCounts.increaseCount(matchType);
    }
}
