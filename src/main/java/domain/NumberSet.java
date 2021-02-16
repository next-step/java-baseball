package domain;

import java.util.ArrayList;
import java.util.List;

public class NumberSet {

    private final List<Number> numbers;

    public NumberSet() {
        this.numbers = new ArrayList<>();
    }

    public NumberSet(final List<Number> numbers) {
        this.numbers = numbers;
    }

    public List<Number> getNumbers() {
        return numbers;
    }

    public void addNumbers(Number number) {
        this.numbers.add(number);
    }
}
