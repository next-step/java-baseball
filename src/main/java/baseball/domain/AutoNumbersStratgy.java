package baseball.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AutoNumbersStratgy implements NumbersStratgy{

    private static final List<BallNumber> NUMBERS;

    static {
        NUMBERS = new ArrayList<>();
        for (int i = BallNumber.MIN_NUMBER; i <= BallNumber.MAX_NUMBER; i++) {
            NUMBERS.add(new BallNumber(i));
        }
    }

    @Override
    public BallNumbers generate() {
        Collections.shuffle(NUMBERS);
        return new BallNumbers(NUMBERS.subList(BallNumbers.MINIMUN_NUMBERS, BallNumbers.LIMIT_NUMBERS));
    }
}
