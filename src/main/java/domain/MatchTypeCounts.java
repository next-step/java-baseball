package domain;

import java.util.HashMap;
import java.util.Map;

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
}
