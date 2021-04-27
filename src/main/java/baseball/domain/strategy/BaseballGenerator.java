package baseball.domain.strategy;

import baseball.domain.BallNumbers;

@FunctionalInterface
public interface BaseballGenerator {
    public BallNumbers generate();
}
