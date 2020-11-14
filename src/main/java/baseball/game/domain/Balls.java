package baseball.game.domain;

import baseball.game.exception.BallsSizeException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Balls {
    public static final Integer LIMIT_BALL_SIZE = 3;

    private final Map<Integer, Ball> balls = new HashMap<>();

    private Balls(List<Ball> balls) {
        validateBalls(balls);

        for(int i = 0; i < balls.size(); i++) {
            this.balls.put(i, balls.get(i));
        }
    }

    public static Balls create(List<Ball> balls) {
        return new Balls(balls);
    }

    public Ball getBall(Integer index) {
        return this.balls.get(index);
    }

    private void validateBalls(List<Ball> balls) {
        validateSize(balls);
    }

    private void validateSize(List<Ball> balls) {
        if(balls.size() > LIMIT_BALL_SIZE) {
            throw new BallsSizeException("3자리 수보다 큽니다.");
        }
        if(balls.size() < LIMIT_BALL_SIZE) {
            throw new BallsSizeException("3자리 수보다 작습니다.");
        }
    }
}
