package game.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class Baseball {

    private List<BallNumber> baseballs;
    private static final int BASEBALL_COUNT = 3;
    private final Map<Unit, Long> count = new HashMap<>();

    public Baseball() {
        baseballs = new ArrayList<>();
    }

    public Baseball(List<BallNumber> baseballs) {
        this.baseballs = baseballs;
    }

    public Baseball(String number) throws IllegalArgumentException {
        List<String> balls = Arrays.asList(number.split(""));
        validateBaseball(balls);
        baseballs = balls.stream()
            .map(BallNumber::new)
            .collect(
                Collectors.toList()
            );
    }

    public void addBall(BallNumber ballNumber) {
        baseballs.add(ballNumber);
    }

    public void calculateStrikeBall(Baseball randomBall) {
        List<BallNumber> randomBalls = randomBall.baseballs;
        count.put(Unit.STRIKE, baseballs.stream().filter(
            randomBalls::contains
        ).filter(
            ball -> baseballs.indexOf(ball) == randomBalls.indexOf(ball)
        ).count());
    }

    public void calculateBall(Baseball randomBall) {
        List<BallNumber> randomBalls = randomBall.baseballs;
        count.put(Unit.BALL, baseballs.stream().filter(
            randomBalls::contains
        ).filter(
            ball -> baseballs.indexOf(ball) != randomBalls.indexOf(ball)
        ).count());
    }

    public Long getStrikeCount() {
        return count.get(Unit.STRIKE);
    }

    public Long getBallCount() {
        return count.get(Unit.BALL);
    }

    private void validateBaseball(List<String> balls) throws IllegalArgumentException {
        Set<String> ballPool = new HashSet<>(balls);
        if (!(balls.size() == BASEBALL_COUNT) || !(ballPool.size() == BASEBALL_COUNT)) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Baseball baseball = (Baseball) o;
        return Objects.equals(baseballs, baseball.baseballs) && Objects
            .equals(count, baseball.count);
    }

    @Override
    public int hashCode() {
        return Objects.hash(baseballs, count);
    }
}
