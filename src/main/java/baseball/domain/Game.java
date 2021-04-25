package baseball.domain;

public class Game {
    private final BallGenerationStrategy generationStrategy;

    public Game(BallGenerationStrategy generationStrategy) {
        this.generationStrategy = generationStrategy;
    }
}
