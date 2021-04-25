package baseball.domain;

public class Game {
    private final static int BALL_SIZE = 3;

    private final BallGenerationStrategy generationStrategy;
    private final Balls computerBalls;

    public Game() {
        this(new RandomBallGenerationStrategy());
    }

    public Game(BallGenerationStrategy generationStrategy) {
        this.generationStrategy = generationStrategy;
        this.computerBalls = generationStrategy.generate(BALL_SIZE);
    }
}
