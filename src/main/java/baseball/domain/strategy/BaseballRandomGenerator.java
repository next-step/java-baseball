package baseball.domain.strategy;

import baseball.domain.BallNumber;
import baseball.domain.BallNumbers;

import java.util.*;

public class BaseballRandomGenerator implements BaseballGenerator{
    private static List<BallNumber> ballNumbers;
    static {
        ballNumbers = new ArrayList<>();
        for (int idx = 1; idx < 10; idx++) {
            ballNumbers.add(new BallNumber(idx));
        }
    }

    @Override
    public BallNumbers generate() {
        Collections.shuffle(ballNumbers);
        return new BallNumbers(ballNumbers.subList(0, 3));
    }
}
