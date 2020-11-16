package model.domain;

import exception.BaseballException;
import exception.ExceptionStatus;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
public class Balls {
    public static final int ZERO = 0;
    public static final int BALLS_COUNT = 3;

    private static final int ADD_COUNT = 1;
    private static final String REGEX = "";

    private List<Ball> balls;

    public Balls(List<Ball> balls) {
        this.balls = balls;
    }

    public static Balls of(String stringNumbers) {
        String[] splitNumbers = stringNumbers.split(REGEX);

        List<Ball> balls = new ArrayList<>();
        for (String splitNumber : splitNumbers) {
            int ballNumber = Integer.parseInt(splitNumber);
            balls.add(Ball.of(ballNumber));
        }

        if (balls.size() != BALLS_COUNT) {
            throw new BaseballException(ExceptionStatus.EXCEEDED_NUMBER_OF_BALL);
        }

        return new Balls(balls);
    }

    public Ball get(int index) {
        return this.balls.get(index);
    }

    public int equalsCount(Balls balls) {
        int count = 0;

        for (int i = 0; i < this.balls.size(); i++) {
            count += calculateEqualsCount(this.balls.get(i), balls.get(i));
        }

        return count;
    }

    private int calculateEqualsCount(Ball ball, Ball targetBall) {
        if (ball.equals(targetBall)) {
            return ADD_COUNT;
        }
        return ZERO;
    }

    public int containCount(Balls balls) {
        int count = 0;

        for (int i = 0; i < this.balls.size(); i++) {
            count += calculateContainCount(balls.get(i));
        }

        return count;
    }

    private int calculateContainCount(Ball ball) {
        if (this.balls.contains(ball)) {
            return ADD_COUNT;
        }
        return ZERO;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Balls balls1 = (Balls) o;
        return Objects.equals(balls, balls1.balls);
    }

    @Override
    public int hashCode() {
        return Objects.hash(balls);
    }
}
