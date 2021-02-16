package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Computer {
    private static final int START = 1;
    private static final int END = 9;
    public static final int LENGTH_OF_NUMBERS = 3;
    private List<Integer> numbers;

    public Computer() {
        generateNumbers();
    }

    private void generateNumbers() {
        numbers = new ArrayList<>();
        for (int i=START; i<=END; i++) {
            numbers.add(i);
        }
        Collections.shuffle(numbers);
        numbers = numbers.subList(0, LENGTH_OF_NUMBERS);
    }
}
