package dev.heowc.player;

import dev.heowc.ball.Balls;
import dev.heowc.ball.BallsGenerator;

import static java.util.Objects.requireNonNull;

public class Pitcher implements Player {

    private final Balls balls;

    public Pitcher(BallsGenerator ballsGenerator) {
        requireNonNull(ballsGenerator, "ballsGenerator");
        this.balls = ballsGenerator.generate();
    }

    @Override
    public Balls getBalls() {
        return balls;
    }
}
