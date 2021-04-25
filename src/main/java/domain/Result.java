package domain;

import java.util.HashMap;
import java.util.Map;

public enum Result {
    STRIKE(ResultCondition.of(true, true)),
    BALL(ResultCondition.of(true, false)),
    NOTHING(ResultCondition.of(false, false));

    private final ResultCondition condition;

    Result(ResultCondition condition) {
        this.condition = condition;
    }

    private static final Map<ResultCondition, Result> RESULT_BY_CONDITION;

    static {
        RESULT_BY_CONDITION = new HashMap<>();
        for (Result result : values()) {
            RESULT_BY_CONDITION.put(result.condition, result);
        }
    }

    public static Result findByCondition(boolean sameNumber, boolean sameNumberAndPosition) {
        return RESULT_BY_CONDITION.getOrDefault(ResultCondition.of(sameNumber, sameNumberAndPosition), null);
    }
}

