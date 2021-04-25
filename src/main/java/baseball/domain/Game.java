package baseball.domain;

public class Game {
    private final BallGenerationStrategy generationStrategy;

    public Game() {
        this(new RandomBallGenerationStrategy());
    }

    public Game(BallGenerationStrategy generationStrategy) {
        this.generationStrategy = generationStrategy;
    }
}
