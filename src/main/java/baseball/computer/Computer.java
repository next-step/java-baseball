package baseball.computer;

import java.util.LinkedHashSet;

import baseball.game.CreateBall;

public class Computer {

    private final LinkedHashSet<Integer> balls;

    public Computer() {
        this.balls = new CreateBall().createRandomBalls();
    }

    public LinkedHashSet<Integer> getBalls() {
        return this.balls;
    }

}
