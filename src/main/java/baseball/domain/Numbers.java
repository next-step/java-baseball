package baseball.domain;

import java.util.*;

import static baseball.view.input.InputMessages.PLEASE_INPUT_VALID_NUMBERS;

public class Numbers {
    private List<String> numbers;

    public Numbers(List<String> numbers) {
        validateNumbers(numbers);
        this.numbers = numbers;
    }

    public Numbers(String... numbers) {
        this(new ArrayList(Arrays.asList(numbers)));
    }

    private void validateNumbers(List<String> numbers) {
        if (validateSize(numbers) || validateDuplicate(numbers)) {
            throw new IllegalArgumentException(PLEASE_INPUT_VALID_NUMBERS);
        }
    }

    private boolean validateSize(List<String> numbers) {
        return numbers.size() != 3;
    }

    private boolean validateDuplicate(List<String> numbers) {
        return new HashSet(numbers).size() != 3;
    }

    public List<String> getNumbers() {
        return numbers;
    }

    public String get(int index) {
        return numbers.get(index);
    }

    public int size() {
        return numbers.size();
    }

    public boolean contains(String value) {
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
