package baseball.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

public class BaseBall implements Iterable<Ball> {
    private final List<Ball> balls;

    public BaseBall(List<Ball> balls) {
        this.balls = balls;
    }

    public static BaseBall of(List<Ball> balls) {
        return new BaseBall(balls);
    }

    public static BaseBall of(String numbers) {
        List<Ball> balls = new ArrayList<>();
        for (int i = 0; i < numbers.length(); i++) {
            Ball ball = Ball.of(numbers.substring(i, i + 1));
            validateDuplicate(balls, ball);
            balls.add(ball);
        }
        return BaseBall.of(balls);
    }

    private static void validateDuplicate(List<Ball> balls, Ball ball) {
        if (balls.contains(ball)) {
            throw new DuplicatedNumberException("숫자는 중복되지 않아야 합니다.");
        }
    }

    public static BaseBall ofRandom(OneDigitNumber oneDigitNumber) {
        List<Ball> balls = new ArrayList<>();
        while (balls.size() < 3) {
            Ball ball = Ball.of(oneDigitNumber);
            if (!balls.contains(ball)) {
                balls.add(ball);
            }
        }
        return BaseBall.of(balls);
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof BaseBall)) {
            return false;
        }
        BaseBall balls1 = (BaseBall) o;
        return Objects.equals(balls, balls1.balls);
    }

    @Override
    public int hashCode() {
        return Objects.hash(balls);
    }
}
