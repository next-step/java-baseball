package baseball;

import java.util.concurrent.ThreadLocalRandom;

public class BaseballGenerator {
    private static final int BASEBALL_SIZE = 3;

    public static BaseballNumber apply() {
        BaseballNumber baseballNumber = new BaseballNumber();

        while (baseballNumber.size() != BASEBALL_SIZE) {
            Integer randomNumberBetweenOneToNine = createRandomNumberBetweenOneToNine();
            baseballNumber.addBaseballNumber(randomNumberBetweenOneToNine);
        }

        return baseballNumber;
    }

    private static Integer createRandomNumberBetweenOneToNine() {
        return ThreadLocalRandom.current().nextInt(9) + 1;
    }
}
