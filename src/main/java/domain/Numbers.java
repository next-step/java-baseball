package domain;

import utils.NumberUtils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Numbers {

    private final List<Number> numbers;

    private Numbers(List<Number> numbers) {
        validateNumbers(numbers);
        this.numbers = numbers;
    }

    public static Numbers of(List<Number> numbers) {
        return new Numbers(numbers);
    }

    public static Numbers of(String inputNumbers) {
        List<Number> numbers = NumberUtils.toList(inputNumbers);
        return new Numbers(numbers);
    }

    private void validateNumbers(List<Number> numbers) {
        if (numbers == null || numbers.size() != 3) {
            throw new IllegalArgumentException("숫자는 3자리 수여야 합니다.");
        }

        if (createNotDuplicatedNumbers(numbers).size() < 3) {
            throw new IllegalArgumentException("숫자는 서로 다른 수여야 합니다.");
        }
    }

    private Set<Number> createNotDuplicatedNumbers(List<Number> numbers) {
        return new HashSet<>(numbers);
    }
}
