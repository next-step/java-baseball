package baseball.domain;

@FunctionalInterface
public interface BallGenerationStrategy {
    Balls generate(int length);
}
