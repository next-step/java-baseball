package util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BaseballNumberGenerator {

    private static final List<Integer> numbers = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9));
    private static final int BASEBALL_NUMBER_MAX_RANGE = 3;

    private BaseballNumberGenerator() {
    }

    public static List<Integer> generator() {
        return getThreeNumbers();
    }

    private static List<Integer> getThreeNumbers() {
        Collections.shuffle(numbers);
        return numbers.subList(0, BASEBALL_NUMBER_MAX_RANGE);
    }
}
