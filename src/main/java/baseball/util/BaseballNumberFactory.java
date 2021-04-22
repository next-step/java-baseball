package baseball.util;

import baseball.domain.BaseballNumbers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BaseballNumberFactory {
    private final List<String> ALL_RANDOM_NUMBERS = new ArrayList();

    public BaseballNumberFactory() {
        for(int i = 1; i <= 9; ++i) {
            this.ALL_RANDOM_NUMBERS.add(String.valueOf(i));
        }

    }

    public BaseballNumbers generateNumbers() {
        Collections.shuffle(this.ALL_RANDOM_NUMBERS);
        List<String> selectedRandomNumber = this.ALL_RANDOM_NUMBERS.subList(0, 3);
        return new BaseballNumbers(selectedRandomNumber);
    }
}
