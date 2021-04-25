package baseball.utils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class RandomNumbersGenerator {
    public static String generateStringNumbers(int length) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        Collections.shuffle(numbers);

        return ListToString(numbers.subList(0, length));
    }

    private static String ListToString(List<Integer> list) {
        String numbers = "";
        for (Integer integer : list) {
            numbers += Integer.toString(integer);
        }
        return numbers;
    }
}
