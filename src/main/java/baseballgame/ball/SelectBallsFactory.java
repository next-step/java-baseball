package baseballgame.ball;

import baseballgame.constant.BallCount;
import baseballgame.constant.BallRange;

import java.util.LinkedHashSet;
import java.util.Random;

public class SelectBallsFactory implements BallsFactory{
    private Integer[] numbers;

    public SelectBallsFactory(Integer[] numbers) {
        this.numbers = numbers;
    }

    @Override
    public LinkedHashSet<Ball> createBalls() {
        LinkedHashSet<Ball> balls = new LinkedHashSet<>();
        for (int number : numbers) {
            balls.add(Ball.createBall(number));
        }
        if(balls.size() < BallCount.COUNT){
            throw new IllegalArgumentException();
        }
        return balls;
    }
}