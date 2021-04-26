package baseball.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public class Ball {
    private static final String INPUT_WITHOUT_DUPLICATE = "중복 없이 숫자를 3개 입력해주세요.";
    private static int MAX_BALL_COUNT = 3;
    private final Set<BallNumber> ballNumbers;

    public Ball(List<BallNumber> ballNumbers) {
        this.ballNumbers = validate(ballNumbers);
    }

    private Set<BallNumber> validate(List<BallNumber> ballNumbers) {
        final Set<BallNumber> set = new HashSet<>();
        for (BallNumber ballNumber : ballNumbers) {
            set.add(ballNumber);
        }
        if (set.size() != MAX_BALL_COUNT) {
            throw new IllegalArgumentException(INPUT_WITHOUT_DUPLICATE);
        }
        return new TreeSet<>(ballNumbers);
    }

    // TODO : match count 를 만들기
    public int getMatchCount(Ball ball) {
        return 0;
    }

    private boolean isBallNumberMatch(BallNumber ballNumber) {
        return ballNumbers.contains(ballNumber);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ball)) return false;
        Ball ball = (Ball) o;
        return Objects.equals(ballNumbers, ball.ballNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ballNumbers);
    }

    @Override
    public String toString() {
        return String.valueOf(ballNumbers);
    }
}
