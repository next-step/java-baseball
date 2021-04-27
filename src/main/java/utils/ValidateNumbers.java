package utils;

import exception.BaseballException;

import java.time.temporal.ValueRange;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ValidateNumbers {

    private static final Integer SIZE = 3;
    private static final Integer PITCHER_MINIMUM_NUMBER = 1;
    private static final Integer PITCHER_MAXIMUM_NUMBER = 9;

    private final List<Integer> numbers;

    public ValidateNumbers(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public void checkNotBeDuplicated() {
        Set<Integer> set = new HashSet<>(numbers);

        if (set.size() != numbers.size()) {
            throw new BaseballException.NotBeDuplicatedException();
        }
    }

    public void checkOutOfRange() {
        numbers.forEach(this::checkOutOfRange);
    }

    private void checkOutOfRange(int number) {
        if (!ValueRange.of(PITCHER_MINIMUM_NUMBER, PITCHER_MAXIMUM_NUMBER).isValidIntValue(number)) {
            throw new BaseballException.PitcherNumberInputOutOfRangeException();
        }
    }

    public void checkDigits() {
        if (numbers.size() != SIZE) {
            throw new BaseballException.DigitsException();
        }
    }

    public void checkAllConditions() {
        checkNotBeDuplicated();
        checkOutOfRange();
        checkDigits();
    }
}
