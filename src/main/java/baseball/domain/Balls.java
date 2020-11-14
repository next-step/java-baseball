package baseball.domain;

import java.util.*;
import java.util.regex.Pattern;

public class Balls {
    private static final String NUMBER_PATTERN = "[1-9]{3}";
    private Map<Integer, Ball> balls;

    public Balls(String numbers) {
        validatePattern(numbers);
        register(numbers);
    }

    public Balls(Map<Integer, Ball> balls) {
        this.balls = balls;
    }

    public Map<Status, Integer> match(Balls target) {
        Set<Integer> numbers = target.balls.keySet();
        Map<Status, Integer> result = new HashMap<>();

        for (int number : numbers) {
            Status status = compareBall(number, target.balls.get(number));
            addResult(result, status);
        }

        return result;
    }

    private void register(String numbers) {
        balls = new HashMap<>();

        for (int i = 0; i < numbers.length(); i++) {
            String numberValue = numbers.substring(i, i + 1);
            addBall(numberValue, i);
        }
    }

    private void addBall(String numberValue, int order) {
        int number = Integer.parseInt(numberValue);
        validateDuplicated(number);

        Ball ball = new Ball(number, order);
        balls.put(number, ball);
    }

    private void validatePattern(String numbers) {
        if (!Pattern.matches(NUMBER_PATTERN, numbers)) {
            throwException();
        }
    }

    private void validateDuplicated(int number) {
        if (balls.containsKey(number)) {
            throwException();
        }
    }

    private void throwException() {
        throw new IllegalArgumentException("1부터 9 사이의 서로 다른 숫자 3개를 입력해주세요.");
    }

    private void addResult(Map<Status, Integer> result, Status status) {
        if (result.containsKey(status)) {
            result.compute(status, (key, value) -> ++value);
            return;
        }

        result.put(status, 1);
    }

    private Status compareBall(int number, Ball targetBall) {
        if (this.balls.containsKey(number)) {
            Ball ball = this.balls.get(number);
            return ball.compare(targetBall);
        }

        return Status.MISS;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Balls balls1 = (Balls) o;
        return Objects.equals(balls, balls1.balls);
    }

    @Override
    public int hashCode() {
        return Objects.hash(balls);
    }
}
