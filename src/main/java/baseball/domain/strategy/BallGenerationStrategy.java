package baseball.domain.strategy;

import baseball.domain.Balls;

@FunctionalInterface
public interface BallGenerationStrategy {
    Balls generate(int length);
}
