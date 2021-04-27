package domain;

import util.RandomGenerator;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Balls {
    private static final String SIZE_ERROR = "숫자볼 개수는 3 입니다";
    private static final String DUPLICATE_ERROR = "중복되는 숫자가 존재합니다.";
    private static final int BALLS_SIZE = 3;
    private static final int ONE = 1;
    private static final int ZERO = 0;

    private final List<Ball> balls;

    public Balls() {
        this(createRandomBalls());
    }

    public Balls(String inputText) {
        this(createInputBalls(inputText));
    }

    public Balls(List<Ball> balls) {
        validBallsSize(balls);
        validDuplicate(balls);
        this.balls = balls;
    }

    public Score matchToScore(Balls inputBalls) {
        int strikeCount = 0;
        int ballCount = 0;

        for (int i = 0; i < BALLS_SIZE; i++) {
            boolean isStrike = inputBalls.isStrike(i, balls.get(i));
            strikeCount += addStrikeCount(isStrike);
            ballCount += inputBalls.addBallCount(isStrike, balls.get(i));
        }
        return new Score(strikeCount, ballCount);
    }

    private int addStrikeCount(boolean isStrike) {
        if (isStrike) {
            return ONE;
        }
        return ZERO;
    }

    private int addBallCount(boolean isStrike, Ball pitchBall) {
        if (!isStrike && balls.contains(pitchBall)) {
            return ONE;
        }
        return ZERO;
    }

    private boolean isStrike(int index, Ball pitchBall) {
        return balls.get(index).equals(pitchBall);
    }

    private static List<Ball> createInputBalls(String inputText) {
        List<Ball> result = new ArrayList<>();

        for (int i = 0; i < inputText.length(); i++) {
            result.add(new Ball(Integer.parseInt(inputText.substring(i, i + 1))));
        }

        return result;
    }

    private static List<Ball> createRandomBalls() {
        RandomGenerator randomGenerator = new RandomGenerator();
        List<Ball> result = new ArrayList<>();

        for (int i = 0; i < BALLS_SIZE; i++) {
            result.add(new Ball(randomGenerator.indexToValue(i)));
        }

        return result;
    }

    private void validDuplicate(List<Ball> balls) {
        Set<Ball> nonDuplicateBalls = new HashSet<>(balls);
        if (nonDuplicateBalls.size() != BALLS_SIZE) {
            throw new IllegalArgumentException(DUPLICATE_ERROR);
        }
    }

    private void validBallsSize(List<Ball> numberBalls) {
        if (numberBalls.size() != BALLS_SIZE) {
            throw new IllegalArgumentException(SIZE_ERROR);
        }
    }
}
