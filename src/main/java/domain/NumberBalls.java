package domain;

import util.RandomGenerator;

import java.util.ArrayList;
import java.util.List;

public class NumberBalls {
    private static final String SIZE_ERROR = "숫자볼 개수는 3 입니다";
    private static final int SIZE = 3;

    private final List<NumberBall> numberBalls;

    public NumberBalls() {
        this(createNumberBalls());
    }

    public NumberBalls(List<NumberBall> numberBalls) {
        validSize(numberBalls);
        this.numberBalls = numberBalls;
    }

    public boolean isSize(int size) {
        return numberBalls.size() == size;
    }

    private static List<NumberBall> createNumberBalls() {
        List<NumberBall> result = new ArrayList<>();
        for (int i = 0; i < SIZE; i++) {
            result.add(new NumberBall(RandomGenerator.value()));
        }
        return result;
    }

    private void validSize(List<NumberBall> numberBalls) {
        if (numberBalls.size() != SIZE) {
            throw new IllegalArgumentException(SIZE_ERROR);
        }
    }
}
