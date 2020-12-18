package baseball.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static baseball.domain.BallNumber.MAX_VALID_NUMBER;
import static baseball.domain.BallNumber.MIN_VALID_NUMBER;
import static baseball.domain.BallNumbers.BALL_NUMBERS_LENGTH;

public class RandomBallNumberGenerator implements NumberGenerateStrategy {
    private static final int FIRST_INDEX = 0;

    @Override
    public List<Integer> generate() {
        List<Integer> candidates = new ArrayList<>();
        for (int i = MIN_VALID_NUMBER; i <= MAX_VALID_NUMBER; i++) {
            candidates.add(i);
        }
        Collections.shuffle(candidates);

        return candidates.subList(FIRST_INDEX, BALL_NUMBERS_LENGTH);
    }
}
