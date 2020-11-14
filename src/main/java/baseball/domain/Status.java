package baseball.domain;

import java.util.HashMap;
import java.util.Map;

public enum Status {
    STRIKE(1, "스트라이크"),
    BALL(0, "볼"),
    OUT(-1, "낫씽");

    private static Map<Integer, Status> matcherMap;
    private int matchType;
    private String displayName;

    static {
        matcherMap = new HashMap<>();
        Status[] values = Status.values();
        for (Status status : values) {
            matcherMap.put(status.matchType, status);
        }
    }

    Status(int matchType, String displayName) {
        this.matchType = matchType;
        this.displayName = displayName;
    }

    public static Status find(int matchType) {
        return matcherMap.getOrDefault(matchType, OUT);
    }

    public String getDisplayName() {
        return displayName;
    }
}
