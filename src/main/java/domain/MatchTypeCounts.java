package domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class MatchTypeCounts {
    private final Map<MatchType, Integer> countByMatchTypes;

    private MatchTypeCounts(Map<MatchType, Integer> countMapByMatchTypes) {
        this.countByMatchTypes = countMapByMatchTypes;
    }

    public static MatchTypeCounts init() {
        Map<MatchType, Integer> countByMatchType = new HashMap<>();
        countByMatchType.put(MatchType.STRIKE, 0);
        countByMatchType.put(MatchType.BALL, 0);
        return new MatchTypeCounts(countByMatchType);
    }

    public int getCountOfMatchType(MatchType matchType) {
        return countByMatchTypes.get(matchType);
    }

    public void increaseCount(MatchType matchType) {
        int originCount = countByMatchTypes.get(matchType);
        countByMatchTypes.put(matchType, originCount + 1);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MatchTypeCounts that = (MatchTypeCounts) o;
        return countByMatchTypes.equals(that.countByMatchTypes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(countByMatchTypes);
    }

    @Override
    public String toString() {
        return "MatchTypeCounts{" +
                "countByMatchTypes=" + countByMatchTypes +
                '}';
    }
}
