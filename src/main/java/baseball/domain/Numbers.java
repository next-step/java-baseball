package baseball.domain;

import java.util.*;

import static baseball.ApplicationContext.EMPTY_DELIMITER;
import static baseball.view.input.InputMessages.PLEASE_INPUT_VALID_NUMBERS;

public class Numbers {
    public final static int SIZE = 3;
    private final List<String> numbers;

    private Numbers(final List<String> numbers) {
        validateNumbers(numbers);
        this.numbers = numbers;
    }

    public static Numbers valueOf(final String numbers) {
        return valueOf(numbers.split(EMPTY_DELIMITER));
    }

    public static Numbers valueOf(final String... numbers) {
        return valueOf(Arrays.asList(numbers));
    }

    public static Numbers valueOf(final List<String> numbers) {
        return new Numbers(new ArrayList(numbers));
    }

    private void validateNumbers(final List<String> numbers) {
        if (Validator.inValidate(numbers)) {
            throw new IllegalArgumentException(PLEASE_INPUT_VALID_NUMBERS);
        }
    }

    public List<String> getNumbers() {
        return numbers;
    }

    public String get(final int index) {
        return numbers.get(index);
    }

    public int size() {
        return numbers.size();
    }

    public boolean contains(final String value) {
        return numbers.contains(value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Numbers numbers1 = (Numbers) o;
        return numbers.equals(numbers1.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
