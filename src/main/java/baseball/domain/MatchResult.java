package baseball.domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class MatchResult {

    private static final int START_MATCH_COUNT = 0;
    private static final int GAME_COMPLETE_COUNT = 3;
    private Map<MatchType, Integer> match;

    public MatchResult() {
        Map<MatchType, Integer> result =
                initMatch(START_MATCH_COUNT,
                        START_MATCH_COUNT,
                        START_MATCH_COUNT);
        this.match = Collections.unmodifiableMap(result);
    }

    private MatchResult(Map<MatchType, Integer> match) {
        Map<MatchType, Integer> result =
                initMatch(match.get(MatchType.STRIKE),
                        match.get(MatchType.BALL),
                        match.get(MatchType.NOTHING));
        this.match = Collections.unmodifiableMap(result);
    }

    private Map<MatchType, Integer> initMatch(final int strike,
                                              final int ball,
                                              final int nothing) {
        Map<MatchType, Integer> result = new HashMap<>();
        result.put(MatchType.STRIKE, strike);
        result.put(MatchType.BALL, ball);
        result.put(MatchType.NOTHING, nothing);
        return result;
    }

    public MatchResult addMatchType(final MatchType type) {
        Map<MatchType, Integer> result = new HashMap<>(this.match);

        Integer count = result.get(type);
        count++;

        result.put(type, count);

        return new MatchResult(result);
    }

    public int getStrikeCount() {
        return this.match.get(MatchType.STRIKE);
    }

    public int getBallCount() {
        return this.match.get(MatchType.BALL);
    }

    public int getNothingCount() {
        return this.match.get(MatchType.NOTHING);
    }

    public boolean isGameComplete() {
        return this.match.get(MatchType.STRIKE) == GAME_COMPLETE_COUNT;
    }

}
