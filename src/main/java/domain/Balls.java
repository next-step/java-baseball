package domain;

import util.RandomGenerator;

import java.util.ArrayList;
import java.util.List;

public class Balls {
    private static final String SIZE_ERROR = "숫자볼 개수는 3 입니다";
    private static final String DUPLICATE_ERROR = "중복되는 숫자가 존재합니다.";
    private static final int SIZE = 3;

    private final List<Ball> balls;

    public Balls() {
        this(createRandomBalls());
    }

    public Balls(String inputText) {
        this(createInputBalls(inputText));
    }

    public Balls(List<Ball> balls) {
        validSize(balls);
        validDuplicate(balls);
        this.balls = balls;
    }

    public Score matchToScore(Balls inputBalls) {
        int strike = 0;
        int ball = 0;

        for (int i = 0; i < SIZE; i++) {
            boolean isStrike = inputBalls.isStrike(i, balls.get(i));
            strike = isStrike ? strike + 1 : strike;
            ball = inputBalls.isBall(isStrike, balls.get(i)) ? ball + 1 : ball;
        }

        return new Score(strike, ball);
    }

    private boolean isBall(boolean isStrike, Ball pitchBall) {
        if (!isStrike) {
            return balls.contains(pitchBall);
        }
        return false;
    }

    private boolean isStrike(int index, Ball pitchBall) {
        return balls.get(index).equals(pitchBall);
    }

    private static List<Ball> createInputBalls(String inputText) {
        List<Ball> result = new ArrayList<>();

        for (int i = 0; i < inputText.length(); i++) {
            int number = Integer.parseInt(inputText.substring(i, i + 1));
            result.add(new Ball(number));
        }

        return result;
    }

    private static List<Ball> createRandomBalls() {
        RandomGenerator randomGenerator = new RandomGenerator();
        List<Ball> result = new ArrayList<>();
        for (int i = 0; i < SIZE; i++) {
            result.add(new Ball(randomGenerator.indexToValue(i)));
        }
        return result;
    }

    private void validDuplicate(List<Ball> balls) {
        int count = 0;
        Ball firstBall = balls.get(0);
        for (int i = 1; i < SIZE; i++) {
            count = isDuplicate(firstBall, balls.get(i)) ? count + 1 : count;
        }
        if (count > 0) {
            throw new IllegalArgumentException(DUPLICATE_ERROR);
        }
    }

    private boolean isDuplicate(Ball firstBall, Ball other) {
        return firstBall.equals(other);
    }

    private void validSize(List<Ball> numberBalls) {
        if (numberBalls.size() != SIZE) {
            throw new IllegalArgumentException(SIZE_ERROR);
        }
    }
}
