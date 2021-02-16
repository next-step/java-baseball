package domain;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class BallNumbers {

    private static final Integer NUMBER_SIZE = 3;

    List<Number> ballNumbers;

    public BallNumbers(List<Number> ballNumbers) {
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
