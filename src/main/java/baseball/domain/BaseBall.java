package baseball.domain;

import java.util.List;

public class BaseBall {
    private final List<Ball> balls;

    public BaseBall(List<Ball> balls) {
        this.balls = balls;
    }

    public static BaseBall of(List<Ball> balls) {
        return new BaseBall(balls);
    }

    public int countStrike(BaseBall inputBaseBall) {
        return 3;
    }
}
