package domain;

import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@EqualsAndHashCode
@ToString
public class Number {
    private static final int DIGIT_LEFT_BOUND = 1;
    private static final int DIGIT_RIGHT_BOUND = 10;
    private static final int DIGIT_LENGTH = 3;

    private static final List<Integer> randomDigits;

    static {
        randomDigits = IntStream
            .range(DIGIT_LEFT_BOUND, DIGIT_RIGHT_BOUND)
            .boxed()
            .collect(Collectors.toList());
    }

    private List<Integer> digits;

    public Number(List<Integer> digits) {
        checkLength(digits);
        checkDigitsBound(digits);
        checkRepeat(digits);
        
        this.digits = digits;
    }

    private void checkLength(List<Integer> digits) {
        if (digits.size() != DIGIT_LENGTH) {
            // TODO : Make error message to constant
            throw new RuntimeException("Wrong length");
        }
    }

    private void checkDigitsBound(List<Integer> digits) {
        digits.forEach(digit -> checkDigitBound(digit));
    }

    private void checkDigitBound(Integer digit) {
        if (digit < DIGIT_LEFT_BOUND || digit >= DIGIT_RIGHT_BOUND) {
            throw new RuntimeException("Wrong digit");
        }
    }

    private void checkRepeat(List<Integer> digits) {
        if (digits.size() != new HashSet<>(digits).size()) {
            throw new RuntimeException("Repeat exist");
        }
    }

    public static Number createByInput(String input) {
        return new Number(
            input
                .chars()
                .mapToObj(digit -> Integer.parseInt(String.valueOf(digit - '0')))
                .collect(Collectors.toList())
        );
    }

    public static Number createByRandom() {
        Collections.shuffle(randomDigits);
        return new Number(
            new ArrayList<>(
                randomDigits.subList(0, DIGIT_LENGTH)
            )
        );
    }
}
