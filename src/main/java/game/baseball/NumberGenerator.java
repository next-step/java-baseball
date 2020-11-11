package game.baseball;

import java.util.*;

public class NumberGenerator {

    private static final List<Integer> NUMBERS;

    static {
        NUMBERS = new ArrayList<>();
        for (int i = Number.MIN_OF_NUMBER; i <= Number.MAX_OF_NUMBER; i++) {
            NUMBERS.add(i);
        }
    }

    public static List<Integer> shuffleAndGet() {
        Collections.shuffle(NUMBERS);
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < Number.NUMBER_OF_DIGITS; i++) {
            numbers.add(NUMBERS.get(i));
        }
        return numbers;
    }
}
