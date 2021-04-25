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

    public void match(Balls balls) {
        if(balls.size() != 3) {
            String errorMessage = String.format("매칭할 공의 개수는 %d개 여야 합니다.", BALL_SIZE);

            throw new IllegalArgumentException(errorMessage);
        }
    }
}
