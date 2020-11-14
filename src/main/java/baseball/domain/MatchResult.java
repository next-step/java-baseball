package baseball.domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class MatchResult {

    private static final int START_MATCH_COUNT = 0;
    private Map<MatchType, Integer> match;

    public MatchResult() {
        Map<MatchType, Integer> result = new HashMap<>();
        result.put(MatchType.STRIKE, START_MATCH_COUNT);
        result.put(MatchType.BALL, START_MATCH_COUNT);
        result.put(MatchType.NOTHING, START_MATCH_COUNT);

        this.match = Collections.unmodifiableMap(result);
    }

    public Map<MatchType, Integer> getMatch() {
        return Collections.unmodifiableMap(this.match);
    }

}
