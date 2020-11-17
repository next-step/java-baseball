package baseball.domain;

import baseball.exception.NumberRangeException;

import java.util.*;

public class BaseballNumbersGenerator {

    private static final int NUMBERS_SIZE_MAX = 3;
    private static final int NUMBER_RANGE_MIN = 1;
    private static final int NUMBER_RANGE_MAX = 9;
    private static final int DECIMAL = 10;

    public BaseballNumbers generateComputerNumbers() {
        Set<Integer> numbers = new HashSet<>();
        Random random = new Random();
        while (numbers.size() < NUMBERS_SIZE_MAX) {
            numbers.add(random.nextInt(NUMBER_RANGE_MAX) + NUMBER_RANGE_MIN);
        }

        return new BaseballNumbers(new ArrayList<>(numbers));
    }

    public BaseballNumbers generateUserNumbers(int input) {
        if (input < 0) {
            throw new NumberRangeException();
        }

        List<Integer> numbers = new ArrayList<>();
        while (input > 0) {
            numbers.add(0, input % DECIMAL);
            input /= DECIMAL;
        }

        return new BaseballNumbers(numbers);
    }
}
