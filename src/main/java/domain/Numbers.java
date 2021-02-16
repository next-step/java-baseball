package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Numbers {

    private final List<Integer> numbers;

    public Numbers(final List<Integer> numbers) {
        Objects.requireNonNull(numbers);
        this.numbers = new ArrayList<>(numbers);
    }

    public int size() {
        return this.numbers.size();
    }

    @Override
    public String toString() {
        return numbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining());
    }
}
