package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AutoChoiceStrategy implements ChoiceStrategy {
    private static final int NUMBER_MIN = 1;
    private static final int NUMBER_MAX = 9;

    private static final List<Number> NUMBERS;

    static {
        NUMBERS = new ArrayList<>();
        for (int i = NUMBER_MIN; i <= NUMBER_MAX; i++) {
            NUMBERS.add(Number.valueOf(i));
        }
    }

    @Override
    public Numbers generate() {
        Collections.shuffle(NUMBERS);
        return Numbers.valueOf(NUMBERS.subList(0, 3));
    }
}
