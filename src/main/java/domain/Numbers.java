package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Numbers {

    private final List<Integer> numbers;

    public Numbers(final List<Integer> numbers) {
        Objects.requireNonNull(numbers);
        validateSize(numbers);
        this.numbers = new ArrayList<>(numbers);
    }

    private void validateSize(final List<Integer> numbers) {
        if (numbers.size() != 3) {
            throw new IllegalArgumentException("숫자는 3자리로 구성되어야 합니다.");
        }
    }

    public int digits() {
        return this.numbers.size();
    }

    @Override
    public String toString() {
        return numbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining());
    }
}
