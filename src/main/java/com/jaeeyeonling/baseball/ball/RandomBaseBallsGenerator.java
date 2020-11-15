package com.jaeeyeonling.baseball.ball;

import java.util.HashSet;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public enum RandomBaseBallsGenerator implements BallsGenerator {

    INSTANCE

    ;

    private final Random random = ThreadLocalRandom.current();

    @Override
    public Balls generate() {
        final var rawBalls = new HashSet<Ball>(Balls.SIZE);
        while (rawBalls.size() < Balls.SIZE) {
            final var rawBall = random.nextInt(Ball.MAX_VALUE + Ball.MIN_VALUE) - Ball.MIN_VALUE;
            final var ball = Ball.valueOf(rawBall);

            rawBalls.add(ball);
        }

        return Balls.of(rawBalls);
    }
}
