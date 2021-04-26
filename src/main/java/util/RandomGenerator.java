package util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomGenerator {
    private static final int MAX_NUMBER = 9;
    private static final int MIN_NUMBER = 1;

    private final List<Integer> numbers;

    public RandomGenerator() {
        numbers = createNumbers();
    }

    private List<Integer> createNumbers() {
        List<Integer> result = new ArrayList<>();
        for (int i = MIN_NUMBER; i <= MAX_NUMBER; i++) {
            result.add(i);
        }
        Collections.shuffle(result);
        return result;
    }

    public int indexToValue(int index) {
        return numbers.get(index);
    }
}
