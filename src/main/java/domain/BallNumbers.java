package domain;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BallNumbers {

    private static final Integer NUMBER_SIZE = 3;

    private final List<Number> ballNumbers;

    public BallNumbers(final List<Number> ballNumbers) {
        this.ballNumbers = ballNumbers;
    }

    public static BallNumbers of(final String numbers) {
        List<Number> result = Arrays
                .stream(numbers.split(""))
                .map(Number::of)
                .collect(Collectors.toList());
        validate(result);
        return new BallNumbers(result);
    }

    public static BallNumbers of(final List<Integer> numbers) {
        List<Number> result = numbers.stream().map(Number::of).collect(Collectors.toList());
        validate(result);
        return new BallNumbers(result);
    }

    private static void validate(final List<Number> numbers) {
        Set<Number> numbs = new HashSet<>(numbers);
        if (numbers.size() != NUMBER_SIZE || numbs.size() != numbers.size()) {
            throw new IllegalArgumentException();
        }
    }

    public BallCount match(BallCount ballCount, BallNumbers otherBallNumbers) {
        ballCount.resetCount();
        IntStream.range(0, NUMBER_SIZE).forEach(i -> {
            ballCount.isStrike(ballNumbers.get(i), otherBallNumbers.ballNumbers.get(i));
            ballCount.isBall(this, ballNumbers.get(i), otherBallNumbers.ballNumbers.get(i));
        });
        return ballCount;
    }

    public boolean contains(Number guessNumber) {
        return this.ballNumbers.contains(guessNumber);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BallNumbers that = (BallNumbers) o;
        return Objects.equals(ballNumbers, that.ballNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ballNumbers);
    }
}
