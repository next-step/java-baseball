package dev.heowc.ball;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SystemInBallsGenerator implements BallsGenerator {

    private final Scanner scanner;

    public SystemInBallsGenerator() {
        this.scanner = new Scanner(System.in);
    }

    @Override
    public Balls generate() {
        final String rawBalls = scanner.nextLine();
        final String[] rawBallArg = rawBalls.split("");
        final List<Ball> ballList = new ArrayList<>(Balls.SIZE);
        for (String rawBall : rawBallArg) {
            final Ball ball = Ball.valueOf(rawBall);
            ballList.add(ball);
        }
        return Balls.of(ballList);
    }
}
