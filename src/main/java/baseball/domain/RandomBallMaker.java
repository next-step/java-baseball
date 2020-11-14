package baseball.domain;

import java.util.*;

public class RandomBallMaker implements BallMaker {
    private static final List<Integer> numbers;
    static {
        numbers = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            numbers.add(i);
        }
    }

    @Override
    public Balls generate() {
        Collections.shuffle(numbers);
        return getBalls();
    }

    private Balls getBalls() {
        Map<Integer, Ball> balls = new HashMap<>();
        for (int order = 0; order < 3; order++) {
            Ball ball = getBall(order);
            balls.put(ball.getNumber(), ball);
        }

        return new Balls(balls);
    }

    private Ball getBall(int order) {
        return new Ball(numbers.get(order), order);
    }
}
