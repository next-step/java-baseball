package baseball.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class BaseballNumberRandomGenerator {

    private BaseballNumberRandomGenerator() {

    }

    private static final List<Integer> numbers = new ArrayList<>();

    static {
        for (int i = BaseballNumber.MIN_NUMBER; i <= BaseballNumber.MAX_NUMBER; i++) {
            numbers.add(i);
        }
    }

    static int[] generateRandomNumbers() {
        Collections.shuffle(numbers);
        return mapToInt(numbers.subList(0, BaseballNumbers.MAX_LENGTH));
    }

    private static int[] mapToInt(List<Integer> numbers) {
        int[] result = new int[BaseballNumbers.MAX_LENGTH];
        for (int number : numbers) {
            result[numbers.indexOf(number)] = number;
        }
        return result;
    }

}
