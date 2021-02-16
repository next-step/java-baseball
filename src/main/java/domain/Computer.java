package domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Computer {

    private static final List<Integer> distinctNumbers = IntStream.rangeClosed(1, 9)
            .boxed()
            .collect(Collectors.toList());
    private static final int NUMBERS_COUNT = 3;

    public static Numbers generateNumbers() {
        Collections.shuffle(distinctNumbers);
        List<Integer> numbers = IntStream.range(0, NUMBERS_COUNT)
                .map(distinctNumbers::get)
                .boxed()
                .collect(Collectors.toList());
        return new Numbers(numbers);
    }
}
