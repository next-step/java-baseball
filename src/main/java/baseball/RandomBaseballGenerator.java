package baseball;

import java.util.concurrent.ThreadLocalRandom;

public class RandomBaseballGenerator {

    public static BaseballNumber apply() {
        BaseballNumber baseballNumber = new BaseballNumber();

        while (baseballNumber.size() != BaseballConstants.BASEBALL_NUMBER_SIZE) {
            Integer randomNumber = createRandomNumberBetweenOneToNine();
            baseballNumber.addNumber(randomNumber);
        }

        return baseballNumber;
    }

    private static Integer createRandomNumberBetweenOneToNine() {
        return ThreadLocalRandom.current().nextInt(9) + 1;
    }
}
