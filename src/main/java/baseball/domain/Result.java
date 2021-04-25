package baseball.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Result {
    private static final int DEFAULT_VALUE = 0;
    private static final int INCREASE = 1;
    private static final int END = 3;

    private Map<Record, Integer> result = new HashMap<>();

    public Result put(List<Record> records) {
        for (Record record : records) {
            result.put(record, result.getOrDefault(record, DEFAULT_VALUE) + INCREASE);
        }
        return this;
    }

    public int countStrike() {
        return result.getOrDefault(Record.STRIKE, DEFAULT_VALUE);
    }

    public int countBall() {
        return result.getOrDefault(Record.BALL, DEFAULT_VALUE);
    }

    public boolean isNothing() {
        return countStrike() == DEFAULT_VALUE && countBall() == DEFAULT_VALUE;
    }

    public boolean isEnd() {
        return result.getOrDefault(Record.STRIKE, DEFAULT_VALUE) == END;
    }
}
