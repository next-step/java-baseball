package baseball.domain;

import java.util.*;

public class Balls {
    private final List<Ball> balls;

    public Balls(Ball ...balls) {
        this(Arrays.asList(balls));
    }

    public Balls(List<Ball> balls) {
        Set<Ball> ballSet = new HashSet<>(balls);
        if(ballSet.size() != balls.size()) {
            throw new IllegalArgumentException("같은 공의 숫자를 가질 수 없습니다.");
        }

        this.balls = balls;
    }

    public GameRules match(Balls destBalls) {
        List<GameRule> gameRules = new ArrayList<>();
        for(int i = 0; i<balls.size(); i++) {
            Ball ball = balls.get(i);

            Position ballPosition = new Position(i);
            Position destBallPosition = destBalls.findPositionByBall(ball);

            gameRules.add(GameRule.of(ballPosition, destBallPosition));
        }

        return new GameRules(gameRules);
    }

    public Position findPositionByBall(Ball ball) {
        int position = balls.indexOf(ball);

        if(position == -1) {
            return Position.NOT_FOUND;
        }

        return new Position(position);
    }

    public int size() {
        return balls.size();
    }
}
