package baseballgame.computer;

import baseballgame.ball.Ball;
import baseballgame.ball.BallsFactory;
import baseballgame.ball.RandomBallsFactory;

import java.util.LinkedHashSet;

public class Computer {
    private LinkedHashSet<Ball> balls = new LinkedHashSet<>();
    private static BallsFactory ballsFactory;

    public LinkedHashSet<Ball> getBalls() {
        return balls;
    }

    public static Computer createComputer() {
        ballsFactory = new RandomBallsFactory();
        Computer computer = new Computer();
        computer.balls = ballsFactory.createBalls();
        return computer;
    }
}