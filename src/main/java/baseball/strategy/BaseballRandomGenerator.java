package baseball.strategy;

import baseball.domain.BallNumbers;

import java.util.Random;

public class BaseballRandomGenerator implements BaseballGenerator{
    private static final Random random = new Random();

    @Override
    public BallNumbers generate() {
        return null;
    }
}
