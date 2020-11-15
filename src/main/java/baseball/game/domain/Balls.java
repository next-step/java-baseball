package baseball.game.domain;

import baseball.game.domain.game.BallResultType;
import baseball.game.exception.BallNumberDuplicateException;
import baseball.game.exception.BallsSizeException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Balls {
    public static final Integer LIMIT_BALL_SIZE = 3;

    private final List<BallWithIndex> balls = new ArrayList<>();

    private Balls(List<Ball> balls) {
        validateBalls(balls);

        for(int i = 0; i < balls.size(); i++) {
            this.balls.add(new BallWithIndex(i, balls.get(i)));
        }
    }

    public static Balls create(List<Ball> balls) {
        return new Balls(balls);
    }

    public BallWithIndex getBall(Integer index) {
        return this.balls.get(index);
    }

    public Integer getBallsSize() {
        return this.balls.size();
    }

    private void validateBalls(List<Ball> balls) {
        validateSize(balls);
        validateDuplicateBall(balls);
    }

    private void validateSize(List<Ball> balls) {
        if(balls.size() > LIMIT_BALL_SIZE) {
            throw new BallsSizeException("3자리 수보다 큽니다.");
        }
        if(balls.size() < LIMIT_BALL_SIZE) {
            throw new BallsSizeException("3자리 수보다 작습니다.");
        }
    }

    private void validateDuplicateBall(List<Ball> balls) {
        Set<Ball> set = new HashSet<>(balls);

        if(set.size() < LIMIT_BALL_SIZE) {
            throw new BallNumberDuplicateException("중복된 숫자가 있습니다.");
        }
    }
}
