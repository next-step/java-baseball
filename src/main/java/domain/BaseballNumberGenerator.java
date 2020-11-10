package domain;

import java.util.*;

public class BaseballNumberGenerator {
    public static Set<BaseballNumber> generate(Random random) {
        Set<BaseballNumber> baseballNumbers = new HashSet<>();

        while (baseballNumbers.size() < 3) {
            baseballNumbers.add(BaseballNumber.of(pickRandomInt(random)));
        }

        return baseballNumbers;
    }

    private static int pickRandomInt(Random random) {
        return random.nextInt((BaseballNumber.MAX_VALUE + 1) - BaseballNumber.MIN_VALUE)
                + BaseballNumber.MIN_VALUE;
    }
}
