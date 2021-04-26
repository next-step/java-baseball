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

    public int size() {
        return numberBalls.size();
    }

    public Score matchToScore(NumberBalls inputBalls) {
        int strike = 0;
        int ball = 0;

        for (int i = 0; i < SIZE; i++) {
            boolean isStrike = inputBalls.isStrike(i, numberBalls.get(i));
            strike = isStrike ? strike + 1 : strike;
            ball = inputBalls.isBall(i, numberBalls.get(i), isStrike) ? ball + 1 : ball;
        }

        return new Score(strike, ball);
    }

    private boolean isBall(int i, NumberBall numberBall, boolean isStrike) {
        if (!isStrike) {
            return numberBalls.contains(numberBall);
        }
        return false;
    }

    private boolean isStrike(int index, NumberBall pitchBall) {
        return numberBalls.get(index).equals(pitchBall);
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
