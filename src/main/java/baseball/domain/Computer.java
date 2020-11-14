package baseball.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static baseball.domain.Number.MAX_NUMBER;
import static baseball.domain.Number.MIN_NUMBER;

public class Computer {
    private static final List<Number> numbers = new ArrayList<>();

    static {
        for (int number = MIN_NUMBER; number <= MAX_NUMBER; number++) {
            numbers.add(new Number(number));
        }
    }

    public static BaseballNumbers create() {
        Collections.shuffle(numbers);
        return BaseballNumbers.from(numbers.subList(0, BaseballNumbers.SIZE));
    }
}
