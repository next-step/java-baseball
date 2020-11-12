package baseball.domain;

import java.util.HashMap;
import java.util.Map;

public enum Matcher {
    STRIKE(1),
    BALL(0),
    NOTHING(-1);

    private static Map<Integer, Matcher> matcherMap;
    private int matchType;

    static {
        matcherMap = new HashMap<>();
        Matcher[] values = Matcher.values();
        for (Matcher matcher : values) {
            matcherMap.put(matcher.matchType, matcher);
        }
    }

    Matcher(int matchType) {
        this.matchType = matchType;
    }

    public static Matcher find(int matchType) {
        return matcherMap.getOrDefault(matchType, NOTHING);
    }
}
