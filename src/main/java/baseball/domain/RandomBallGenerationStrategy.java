package baseball.domain;

import java.util.*;

public class RandomBallGenerationStrategy implements BallGenerationStrategy{
    private static final int RANDOM_PADDING = 1;

    @Override
    public Balls generate(int length) {
        Random random = new Random(System.currentTimeMillis());

        Set<Ball> balls = new HashSet<>();
        while(balls.size() < length) {
            balls.add(
                    Ball.of(random.nextInt(Ball.MAXIMUM_NUMBER - Ball.MINIMUM_NUMBER + RANDOM_PADDING) + Ball.MINIMUM_NUMBER)
            );
        }

        List<Ball> selectedBalls = new ArrayList<>(balls);
        Collections.shuffle(selectedBalls);

        return new Balls(selectedBalls);
    }
}
