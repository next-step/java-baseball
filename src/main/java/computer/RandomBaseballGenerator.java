package computer;

import baseball.BaseballConstants;
import baseball.BaseballNumbers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

public class RandomBaseballGenerator {

    public static BaseballNumbers apply() {
        Set<Integer> integers = new HashSet<>();
        while (integers.size() != BaseballConstants.BASEBALL_NUMBER_SIZE) {
            integers.add(createRandomNumberBetweenOneToNine());
        }
        return BaseballNumbers.create(new ArrayList<>(integers));
    }

    private static Integer createRandomNumberBetweenOneToNine() {
        return ThreadLocalRandom.current().nextInt(9) + 1;
    }
}
