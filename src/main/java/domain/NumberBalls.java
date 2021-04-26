package domain;

import util.RandomGenerator;

import java.util.ArrayList;
import java.util.List;

public class NumberBalls {
    private static final int SIZE = 3;

    private final List<NumberBall> numberBalls;

    public NumberBalls() {
        numberBalls = createNumberBalls();
    }

    public boolean isSize(int size) {
        return numberBalls.size() == size;
    }

    private List<NumberBall> createNumberBalls() {
        List<NumberBall> result = new ArrayList<>();
        for (int i = 0; i < SIZE; i++) {
            result.add(new NumberBall(RandomGenerator.value()));
        }
        return result;
    }
}
