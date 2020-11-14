package baseball.domain;

import java.util.HashMap;
import java.util.Map;

public class BaseballResult {

    public static final int DEFAULT_COUNT = 0;
    private Map<ResultType, Integer> result = new HashMap<>();

    void add(ResultType resultType) {
        if (resultType == ResultType.NOTHING) {
            return;
        }
        int count = result.getOrDefault(resultType, DEFAULT_COUNT);
        result.put(resultType, count + 1);
    }

    public int getCountOfStrike() {
        return result.getOrDefault(ResultType.STRIKE, DEFAULT_COUNT);
    }

    public int getCountOfBall() {
        return result.getOrDefault(ResultType.BALL, DEFAULT_COUNT);
    }

    public boolean isEmpty() {
        return result.isEmpty();
    }

    public boolean isEnd() {
        return result.getOrDefault(ResultType.STRIKE, DEFAULT_COUNT) == BaseballNumbers.MAX_LENGTH;
    }

}
