package domain;

import java.util.*;

public class BaseballNumberGenerator {
    private static final Random random = new Random();
    private static final List<BaseballNumber> cachedNumbers;

    static {
        cachedNumbers = new ArrayList<>();
        for (int i = 0; i <= 9; i++) {
            cachedNumbers.add(new BaseballNumber(i));
        }
    }

    private BaseballNumberGenerator() {

    }

    public static BaseballNumber getBaseballNumber(int index) {
        return cachedNumbers.get(index);
    }

    public static BaseballNumber getRandomNumber() {
        return getBaseballNumber(getRandomIntSingleDigit());
    }

    public static List<BaseballNumber> generateThreeLengthRandomNumber() {
        Set<BaseballNumber> baseballNumbers = new HashSet<>();
        while (baseballNumbers.size() != 3) {
            baseballNumbers.add(BaseballNumberGenerator.getRandomNumber());
        }
        return new ArrayList<>(baseballNumbers);
    }

    private static int getRandomIntSingleDigit() {
        return random.nextInt(10);
    }
}
