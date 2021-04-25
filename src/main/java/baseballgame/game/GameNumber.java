package baseballgame.game;

import java.util.Collections;
import java.util.List;

public class GameNumber {
    private static final int DIGITS = 3;
    private static final int LOWER_BOUND = 1;
    private static final int UPPER_BOUND = 9;

    private final List<Integer> numberList;

    private GameNumber(List<Integer> numberList) {
        this.numberList = Collections.unmodifiableList(numberList);
    }

    public static GameNumber generateRandomly() {
        final List<Integer> numberList = RandomNumberGenerator.generateRandomNumberList(LOWER_BOUND, UPPER_BOUND, DIGITS);
        return new GameNumber(numberList);
    }

}
