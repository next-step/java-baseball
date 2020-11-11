package domain;

import java.util.*;

public class RandomBaseballNumbersGenerator implements BaseballNumbersGenerator {
    private static final Random RANDOM = new Random();

    public BaseballNumbers generate() {
        Set<BaseballNumber> baseballNumbers = new HashSet<>();

        while (baseballNumbers.size() < 3) {
            baseballNumbers.add(BaseballNumber.of(pickRandomInt()));
        }

        return new BaseballNumbers(new ArrayList<>(baseballNumbers));
    }

    private int pickRandomInt() {
        return RANDOM.nextInt((BaseballNumber.MAX_VALUE + 1) - BaseballNumber.MIN_VALUE)
                + BaseballNumber.MIN_VALUE;
    }
}
