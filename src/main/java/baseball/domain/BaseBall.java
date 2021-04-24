package baseball.domain;

import java.util.Iterator;
import java.util.List;
import java.util.stream.IntStream;

public class BaseBall implements Iterable<Ball> {
    private final List<Ball> balls;

    public BaseBall(List<Ball> balls) {
        this.balls = balls;
    }

    public static BaseBall of(List<Ball> balls) {
        return new BaseBall(balls);
    }

    public int countStrike(BaseBall inputBaseBall) {
        return IntStream.range(0, balls.size())
            .map(i -> inputBaseBall.countStrike(i, balls.get(i)))
            .sum();
    }

    private int countStrike(int index, Ball ball) {
        if (balls.get(index).equals(ball)) {
            return 1;
        }
        return 0;
    }

    public int countBall(BaseBall inputBaseBall) {
        return balls.stream().mapToInt(inputBaseBall::countBall)
            .sum();
    }

    private int countBall(Ball ball) {
        if (balls.contains(ball)) {
            return 1;
        }
        return 0;
    }

    @Override
    public Iterator<Ball> iterator() {
        return balls.iterator();
    }
}
