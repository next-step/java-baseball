package domain;

import util.RandomGenerator;

import java.util.ArrayList;
import java.util.List;

public class Balls {
    private static final String SIZE_ERROR = "숫자볼 개수는 3 입니다";
    private static final int SIZE = 3;

    private final List<Ball> numberBalls;

    public Balls() {
        this(createNumberBalls());
    }

    public Balls(List<Ball> numberBalls) {
        validSize(numberBalls);
        this.numberBalls = numberBalls;
    }

    public boolean isSize(int size) {
        return numberBalls.size() == size;
    }

    public int size() {
        return numberBalls.size();
    }

    public Score matchToScore(Balls inputBalls) {
        int strike = 0;
        int ball = 0;

        for (int i = 0; i < SIZE; i++) {
            boolean isStrike = inputBalls.isStrike(i, numberBalls.get(i));
            strike = isStrike ? strike + 1 : strike;
            ball = inputBalls.isBall(i, numberBalls.get(i), isStrike) ? ball + 1 : ball;
        }

        return new Score(strike, ball);
    }

    private boolean isBall(int i, Ball numberBall, boolean isStrike) {
        if (!isStrike) {
            return numberBalls.contains(numberBall);
        }
        return false;
    }

    private boolean isStrike(int index, Ball pitchBall) {
        return numberBalls.get(index).equals(pitchBall);
    }

    private static List<Ball> createNumberBalls() {
        List<Ball> result = new ArrayList<>();
        for (int i = 0; i < SIZE; i++) {
            result.add(new Ball(RandomGenerator.value()));
        }
        return result;
    }

    private void validSize(List<Ball> numberBalls) {
        if (numberBalls.size() != SIZE) {
            throw new IllegalArgumentException(SIZE_ERROR);
        }
    }
}
