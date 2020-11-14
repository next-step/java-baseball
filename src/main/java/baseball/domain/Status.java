package baseball.domain;

import java.util.HashMap;
import java.util.Map;

public enum Status {
    STRIKE(1),
    BALL(0),
    MISS(-1);

    private static Map<Integer, Status> matcherMap;
    private int matchType;

    static {
        matcherMap = new HashMap<>();
        Status[] values = Status.values();
        for (Status status : values) {
            matcherMap.put(status.matchType, status);
        }
    }

    Status(int matchType) {
        this.matchType = matchType;
    }

    public static Status find(int matchType) {
        return matcherMap.getOrDefault(matchType, MISS);
    }
}
