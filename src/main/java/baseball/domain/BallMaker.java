package baseball.domain;

import java.util.*;

public class BallMaker {
    private static final List<Integer> numbers;
    static {
        numbers = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            numbers.add(i);
        }
    }

    public List<Ball> getThreeNumbers() {
        Collections.shuffle(numbers);
        return getThreeBalls();
    }

    private List<Ball> getThreeBalls() {
        List<Ball> balls = new ArrayList<>();
        for (int order = 0; order < 3; order++) {
            Ball ball = getBall(order);
            balls.add(ball);
        }

        return balls;
    }

    private Ball getBall(int order) {
        return new Ball(numbers.get(order), order);
    }
}
