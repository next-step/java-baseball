package game.baseball;

import java.util.*;

public class BaseBallNumberGenerator {

    private static final List<Integer> NUMBERS;

    static {
        NUMBERS = new ArrayList<>();
        for (int i = BaseBallNumber.MIN_OF_NUMBER; i <= BaseBallNumber.MAX_OF_NUMBER; i++) {
            NUMBERS.add(i);
        }
    }

    public static List<BaseBallNumber> shuffleAndGet() {
        Collections.shuffle(NUMBERS);
        List<BaseBallNumber> numbers = new ArrayList<>();
        for (int i = 0; i < BaseBallNumbers.NUMBER_OF_DIGITS; i++) {
            numbers.add(BaseBallNumber.of(NUMBERS.get(i)));
        }
        return numbers;
    }
}
