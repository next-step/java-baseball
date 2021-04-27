package baseball.domain;

import baseball.domain.strategy.BallGenerationStrategy;
import baseball.domain.strategy.RandomBallGenerationStrategy;

public class Game {
    public static final int BALL_SIZE = 3;

    private final Balls computerBalls;

    public Game() {
        this(new RandomBallGenerationStrategy());
    }

    public Game(BallGenerationStrategy generationStrategy) {
        this.computerBalls = generationStrategy.generate(BALL_SIZE);
    }

    public Score match(Balls balls) {
        if (balls.size() != BALL_SIZE) {
            throw new IllegalArgumentException(String.format("매칭할 공의 개수는 %d개 여야 합니다.", BALL_SIZE));
        }

        return computerBalls.match(balls);
    }
}
