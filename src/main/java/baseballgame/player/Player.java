package baseballgame.player;

import baseballgame.ball.Ball;
import baseballgame.ball.BallsFactory;
import baseballgame.ball.SelectBallsFactory;
import baseballgame.constant.BallCount;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class Player {
    private LinkedHashSet<Ball> balls = new LinkedHashSet<>();
    private static BallsFactory ballsFactory;

    public static Player createPlayer(Integer[] numbers) {
        ballsFactory = new SelectBallsFactory(numbers);
        if (!isValid(numbers)) {
            throw new IllegalArgumentException();
        }
        Player player = new Player();
        player.balls = ballsFactory.createBalls();
        return player;
    }

    public LinkedHashSet<Ball> getBalls() {
        return balls;
    }

    public static boolean isValid(Integer[] numbers) {
        Set<Integer> integerSet = new HashSet<>();
        for (int number : numbers) {
            if (Ball.isValid(number)) {
                integerSet.add(number);
            }
        }
        if (integerSet.size() == BallCount.COUNT)
            return true;
        return false;
    }
}
