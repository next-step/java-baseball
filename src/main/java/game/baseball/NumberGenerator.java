package game.baseball;

import java.util.*;

public class NumberGenerator {

    private static final List<Integer> NUMBERS;

    static {
        NUMBERS = new ArrayList<>();
        for (int i = NumberBall.MIN_OF_NUMBER; i <= NumberBall.MAX_OF_NUMBER; i++) {
            NUMBERS.add(i);
        }
    }

    public static Set<Integer> shuffleAndGet() {
        Collections.shuffle(NUMBERS);
        Set<Integer> numbers = new HashSet<>();
        for (int i = 0; i < NumberBall.NUMBER_OF_DIGITS; i++) {
            numbers.add(NUMBERS.get(i));
        }
        return numbers;
    }
}
