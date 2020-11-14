package domain;

import java.util.Map;

public class CountMatchTypes {
    private final Map<MatchType, CountByMatchType> countByMatchTypes;

    public CountMatchTypes(Map<MatchType, CountByMatchType> countByMatchTypes) {
        this.countByMatchTypes = countByMatchTypes;
    }

    public int getCountOfType(MatchType matchType) {
        CountByMatchType countByMatchType = countByMatchTypes.get(matchType);
        return countByMatchType.getCount();
    }

    public void increase(MatchType matchType) {
        CountByMatchType countByMatchType = countByMatchTypes.get(matchType);
        countByMatchType.increaseCount();
    }
}
