package baseball.domain;

import baseball.domain.exception.DuplicatedNumberException;
import baseball.domain.exception.NoThreeDigitException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BaseBall implements Iterable<Ball> {
    private static final int BALLS_LENGTH = 3;
    private final List<Ball> balls;

    private BaseBall(List<Ball> balls) {
        this.balls = balls;
    }

    public static BaseBall of(String numbers) {
        validationThreeDigit(numbers);
        List<Ball> balls = makeBalls(numbers);
        validationDuplicate(balls);
        return new BaseBall(balls);
    }

    private static void validationThreeDigit(String numbers) {
        if (numbers.length() != BALLS_LENGTH) {
            throw new NoThreeDigitException("세자리 숫자를 입력해주세요.");
        }
    }

    private static List<Ball> makeBalls(String numbers) {
        return numbers.chars()
            .mapToObj(number -> Ball.of(String.valueOf((char) number)))
            .distinct()
            .collect(Collectors.toList());
    }

    private static void validationDuplicate(List<Ball> balls) {
        if (balls.size() < BALLS_LENGTH) {
            throw new DuplicatedNumberException("숫자는 중복되지 않아야 합니다.");
        }
    }

    public static BaseBall of(OneDigitNumber oneDigitNumber) {
        List<Ball> balls = new ArrayList<>();
        while (balls.size() < BALLS_LENGTH) {
            Ball ball = Ball.of(oneDigitNumber);
            if (!balls.contains(ball)) {
                balls.add(ball);
            }
        }
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
            .sum() - countStrike(inputBaseBall);
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
