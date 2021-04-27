package baseball.domain;

import baseball.exception.InvalidNumbersException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static baseball.ApplicationContext.EMPTY_DELIMITER;
import static baseball.view.input.InputMessages.PLEASE_INPUT_VALID_NUMBERS;

public class Numbers {
    public final static int SIZE = 3;
    private final List<Number> numbers;

    private Numbers(final List<Number> numbers) {
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
        final List<Number> list = new ArrayList<>();
        for (final String value : numbers) {
            list.add(Number.valueOf(value));
        }
        return new Numbers(list);
    }

    private void validateNumbers(final List<Number> numbers) {
        if (Validator.inValidate(numbers)) {
            throw new InvalidNumbersException(PLEASE_INPUT_VALID_NUMBERS);
        }
    }

    public List<Number> getNumbers() {
        return numbers;
    }

    public Number get(final int index) {
        return numbers.get(index);
    }

    public int size() {
        return numbers.size();
    }

    public boolean contains(final Number value) {
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
