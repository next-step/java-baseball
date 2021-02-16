package domain;

import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Collections;
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
        this.digits = digits;
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
