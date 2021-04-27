package baseball.util;

import baseball.domain.BaseballNumbers;

import java.util.ArrayList;
import java.util.List;

import static baseball.domain.BaseballNumbers.*;
import static java.util.Collections.shuffle;

public class BaseballNumberFactory {
    private final List<String> ALL_RANDOM_NUMBERS = new ArrayList<>();

    public BaseballNumberFactory() {
        for (int i = MIN_RANDOM_NUMBER; i <= MAX_RANDOM_NUMBER; ++i) {
            this.ALL_RANDOM_NUMBERS.add(String.valueOf(i));
        }
    }

    public BaseballNumbers generateNumbers() {
        shuffle(this.ALL_RANDOM_NUMBERS);
        List<String> selectedRandomNumber = this.ALL_RANDOM_NUMBERS.subList(0, RANDOM_NUMBER_COUNT);

        return new BaseballNumbers(selectedRandomNumber);
    }
}
