package baseball.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Balls {
    private static final int NOT_FOUND_INDEX = -1;

    private final List<Ball> balls;

    public Balls(Ball... balls) {
        this(Arrays.asList(balls));
    }

    public Balls(List<Ball> balls) {
        Set<Ball> ballSet = new HashSet<>(balls);
        if (ballSet.size() != balls.size()) {
            throw new IllegalArgumentException("같은 공의 숫자를 가질 수 없습니다.");
        }

        this.balls = balls;
    }

    public Score match(Balls destBalls) {
        List<Pitching> pitchings = new ArrayList<>();
        for (int i = 0; i < balls.size(); i++) {
            Ball ball = balls.get(i);

            Position ballPosition = new Position(i);
            Position destBallPosition = destBalls.findPositionByBall(ball);

            pitchings.add(ballPosition.compare(destBallPosition));
        }

        return new Score(pitchings);
    }

    public Position findPositionByBall(Ball ball) {
        int position = balls.indexOf(ball);

        if (position == NOT_FOUND_INDEX) {
            return Position.NOT_FOUND;
        }

        return new Position(position);
    }

    public int size() {
        return balls.size();
    }
}
