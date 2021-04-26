package util;

import view.InputView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class RandomGenerator {
    private static final int MAX_NUMBER = 9;
    private static final int MIN_NUMBER = 1;
    private static final Random random = new Random();

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
