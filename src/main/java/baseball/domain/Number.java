package baseball.domain;

import baseball.exception.IncorrectNumbersException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Number {

    private static final List<Integer> ALLOWED_DIGITS = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
    private final List<Integer> digits;

    public Number(List<Integer> digits) {
        this.digits = digits;
        validateDigits();
    }

    public List<Integer> getDigits() {
        return digits;
    }

    public static Number generateRandomNumber(Integer size) {
        List<Integer> allowedDigits = new ArrayList<>(ALLOWED_DIGITS);
        Collections.shuffle(allowedDigits);
        List<Integer> shuffledDigits = allowedDigits.subList(0, size);
        return new Number(shuffledDigits);
    }

    private void validateDigits() {
        if (digits == null || digits.isEmpty()) {
            throw new IncorrectNumbersException("숫자가 비었습니다.");
        }
        if (!ALLOWED_DIGITS.containsAll(digits)) {
            throw new IncorrectNumbersException("허용되지 않은 숫자가 존재합니다.");
        }
        if (new HashSet<>(digits).size() != digits.size()) {
            throw new IncorrectNumbersException("중복된 숫자가 존재합니다.");
        }
    }
}
