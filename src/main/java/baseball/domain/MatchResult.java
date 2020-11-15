package baseball.domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class MatchResult {

    private static final int START_MATCH_COUNT = 0;
    private static final int GAME_COMPLETE_COUNT = 3;
    private Map<MatchType, Integer> match;

    public MatchResult() {
        Map<MatchType, Integer> result = new HashMap<>();
        result.put(MatchType.STRIKE, START_MATCH_COUNT);
        result.put(MatchType.BALL, START_MATCH_COUNT);
        result.put(MatchType.NOTHING, START_MATCH_COUNT);

        this.match = Collections.unmodifiableMap(result);
    }

    private MatchResult(Map<MatchType, Integer> match) {
        Map<MatchType, Integer> result = new HashMap<>();
        result.put(MatchType.STRIKE, match.get(MatchType.STRIKE));
        result.put(MatchType.BALL, match.get(MatchType.BALL));
        result.put(MatchType.NOTHING, match.get(MatchType.NOTHING));

        this.match = Collections.unmodifiableMap(result);
    }

    public MatchResult addMatchType(final MatchType type) {
        Map<MatchType, Integer> result = new HashMap<>(this.match);

        Integer count = result.get(type);
        count++;

        result.put(type, count);

        return new MatchResult(result);
    }

    public Map<MatchType, Integer> getMatch() {
        return Collections.unmodifiableMap(this.match);
    }

    public boolean isGameComplete() {
        return this.match.get(MatchType.STRIKE) == GAME_COMPLETE_COUNT;
    }

}
