package domain;

import java.util.HashMap;
import java.util.Map;

public class GuessResult {
    private final CountMatchTypes countMatchTypes;

    private GuessResult(CountMatchTypes countMatchTypes) {
        this.countMatchTypes = countMatchTypes;
    }

    public static GuessResult init() {
        Map<MatchType, CountByMatchType> countByMatchTypes = new HashMap<>();
        countByMatchTypes.put(MatchType.STRIKE, CountByMatchType.init(MatchType.STRIKE));
        countByMatchTypes.put(MatchType.BALL, CountByMatchType.init(MatchType.BALL));
        return new GuessResult(new CountMatchTypes(countByMatchTypes));
    }

    public int getStrikeCount() {
        return countMatchTypes.getCountOfType(MatchType.STRIKE);
    }

    public int getBallCount() {
        return countMatchTypes.getCountOfType(MatchType.BALL);
    }

    public boolean isThreeStrike() {
        return countMatchTypes.getCountOfType(MatchType.STRIKE) == 3;
    }

    public boolean isNothing() {
        return countMatchTypes.getCountOfType(MatchType.STRIKE) == 0
                && countMatchTypes.getCountOfType(MatchType.BALL) == 0;
    }

    public void increase(MatchType matchType) {
        if (matchType == MatchType.NO_MATCH) {
            return;
        }
        countMatchTypes.increase(matchType);
    }
}
