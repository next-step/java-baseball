package domain;

import java.util.HashMap;
import java.util.Map;

public class GuessResult {
    private final CountMatchTypes countMatchTypes;

    private GuessResult(CountMatchTypes countMatchTypes) {
        this.countMatchTypes = countMatchTypes;
    }

    public static GuessResult init() {
        Map<MatchType, Integer> countByMatchTypes = new HashMap<>();
        countByMatchTypes.put(MatchType.STRIKE, 0);
        countByMatchTypes.put(MatchType.BALL, 0);
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
