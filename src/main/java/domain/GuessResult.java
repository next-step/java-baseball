package domain;

import java.util.Objects;

public class GuessResult {
    private final MatchTypeCounts matchTypeCounts;

    protected GuessResult(MatchTypeCounts matchTypeCounts) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GuessResult that = (GuessResult) o;
        return matchTypeCounts.equals(that.matchTypeCounts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(matchTypeCounts);
    }

    @Override
    public String toString() {
        return "GuessResult{" +
                "matchTypeCounts=" + matchTypeCounts +
                '}';
    }
}
