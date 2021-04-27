package baseball.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BaseballNumberValidator {

    public boolean isValid(List<Integer> numbers) {
        if (!isThreeDigits(numbers)) {
            return false;
        }
        if (isIncludeZero(numbers)) {
            return false;
        }
        if (haveDuplicatedNumbers(numbers)) {
            return false;
        }
        return true;
    }

    private boolean isThreeDigits(List<Integer> numbers) {
        return numbers.size() == GameRule.NUMBER_OF_DIGITS;
    }

    private boolean isIncludeZero(List<Integer> numbers) {
        return numbers.contains(0);
    }

    private boolean haveDuplicatedNumbers(List<Integer> numbers) {
        Set<Integer> copyOfNumbers = new HashSet<>(numbers);
        return copyOfNumbers.size() != numbers.size();
    }
}
