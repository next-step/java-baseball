package domain;

import java.util.*;

public class RandomBaseballNumberGenerator implements BaseballNumberGenerator {
    private static final Random RANDOM = new Random();

    public Set<BaseballNumber> generate() {
        Set<BaseballNumber> baseballNumbers = new HashSet<>();

        while (baseballNumbers.size() < 3) {
            baseballNumbers.add(BaseballNumber.of(pickRandomInt()));
        }

        return baseballNumbers;
    }

    private int pickRandomInt() {
        return RANDOM.nextInt((BaseballNumber.MAX_VALUE + 1) - BaseballNumber.MIN_VALUE)
                + BaseballNumber.MIN_VALUE;
    }
}
