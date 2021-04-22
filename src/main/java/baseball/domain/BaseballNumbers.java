package baseball.domain;

import java.util.List;

public class BaseballNumbers {
    public static final int MAX_RANDOM_NUMBER = 9;
    public static final int MIN_RANDOM_NUMBER = 1;
    public static final int RANDOM_NUMBER_COUNT = 3;
    private final List<String> values;

    public BaseballNumbers(List<String> values) {
        this.values = values;
    }

    public List<String> getValues() {
        return this.values.subList(0, 3);
    }

    public int size() {
        return this.values.size();
    }
}
