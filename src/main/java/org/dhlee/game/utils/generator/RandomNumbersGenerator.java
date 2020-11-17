package org.dhlee.game.utils.generator;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class RandomNumbersGenerator {
    public static List<Integer> generate(Integer[] list, int range) {
        List<Integer> numbers = Arrays.asList(list);
        Collections.shuffle(numbers);

        return numbers.subList(0, range);
    }
}
