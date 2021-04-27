package baseball.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.ArrayList;
import java.util.Collections;

public class RandomBallGenerationStrategy implements BallGenerationStrategy{
    private static final int CALCULATE_PADDING = 1;

    @Override
    public Balls generate(int length) {
        Random random = new Random(System.currentTimeMillis());

        Set<Ball> balls = new HashSet<>();
        while(balls.size() < length) {
            balls.add(
                    Ball.of(random.nextInt(Ball.MAXIMUM_NUMBER - Ball.MINIMUM_NUMBER + CALCULATE_PADDING) + Ball.MINIMUM_NUMBER)
            );
        }

        List<Ball> selectedBalls = new ArrayList<>(balls);
        Collections.shuffle(selectedBalls);

        return new Balls(selectedBalls);
    }
}
