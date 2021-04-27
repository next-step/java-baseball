package playball.domain;

import playball.exception.PlayBallIllegalArgumentException;
import playball.util.NumberGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Balls {

    public static final Integer BALLS_SIZE = 3;
    public static final Integer UPPER_BOUND_OF_RANDOM_BALL_NUMBER = 9;

    private final List<Ball> balls;

    private Balls(List<Ball> balls) {
        validate(balls);
        this.balls = balls;
    }

    private void validate(List<Ball> balls) {
        if (!isValidBallsSize(balls)) {
            throw new PlayBallIllegalArgumentException();
        }
    }

    private Boolean isValidBallsSize(List<Ball> balls) {
        return balls.size() == BALLS_SIZE;
    }

    public List<Ball> getBalls() {
        return Collections.unmodifiableList(balls);
    }

    public static Balls of(List<Ball> balls) {
        return new Balls(balls);
    }

    public static Balls createRandomBalls() {
        Set<Ball> balls = new HashSet<>();
        while (balls.size() != BALLS_SIZE) {
            Integer generated = NumberGenerator.generateNumbers(UPPER_BOUND_OF_RANDOM_BALL_NUMBER);
            Ball ball = Ball.of(generated);
            balls.add(ball);
        }
        return Balls.of(new ArrayList<>(balls));
    }
}
