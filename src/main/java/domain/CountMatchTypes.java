package domain;

import java.util.Map;

public class CountMatchTypes {
    private final Map<MatchType, Integer> countByMatchTypes;

    public CountMatchTypes(Map<MatchType, Integer> countMapByMatchTypes) {
        this.countByMatchTypes = countMapByMatchTypes;
    }

    public int getCountOfType(MatchType matchType) {
        return countByMatchTypes.get(matchType);
    }

    public void increase(MatchType matchType) {
        int originCount = countByMatchTypes.get(matchType);
        countByMatchTypes.put(matchType, originCount + 1);
    }
}
