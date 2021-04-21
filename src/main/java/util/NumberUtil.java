package util;

import domain.Number;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class NumberUtil {
    public static Number generateRandomNumber() {
        List<String> numbers = Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9");
        Collections.shuffle(numbers);

        return new Number(String.join("", numbers.subList(0, 3)));
    }
}
