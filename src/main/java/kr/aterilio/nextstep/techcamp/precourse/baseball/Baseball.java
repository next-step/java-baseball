package kr.aterilio.nextstep.techcamp.precourse.baseball;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;

public class Baseball {

    private static final int GAME_BOUND = 9;

    private static final int MAX_PICK = 30;
    private static final int GAME_SIZE = 3;

    private final Set<Integer> numbers = new LinkedHashSet<>();

    public Baseball() {
        createGame();
    }

    public Baseball(Integer[] array) {
        numbers.addAll(Arrays.asList(array));
    }

    private void createGame() {
        for(int i = 0; i < MAX_PICK && numbers.size() < GAME_SIZE; ++i) {
            numbers.add(pick());
        }
    }

    private int pick() {
        // 0 <= n <= GAME_BOUND - 1
        //      -> 1 <= n <= GAME_BOUND
        return new Random().nextInt(GAME_BOUND) + 1;
    }

    public boolean isCreated() {
        return numbers.size() == GAME_SIZE;
    }

    public boolean isEqualTo(Integer[] input) {
        return Arrays.deepEquals(numbers.toArray(), input);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
