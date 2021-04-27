package baseballgame.ball;

import baseballgame.constant.BallCount;
import baseballgame.constant.BallRange;

import java.util.LinkedHashSet;
import java.util.Random;

public class RandomBallsFactory implements BallsFactory{
    private static final Random random = new Random();

    @Override
    public LinkedHashSet<Ball> createBalls() {
        LinkedHashSet<Ball> balls = new LinkedHashSet<>();
        while (balls.size() < BallCount.COUNT) {
            int randomNumber = random.nextInt(BallRange.MAX_NUMBER) + BallRange.MIN_NUMBER;
            if (Ball.isValid(randomNumber)) {
                balls.add(Ball.createBall(randomNumber));
            }
        }
        return balls;
    }
}
