package baseball.model;

import baseball.value.Result;
import baseball.config.BaseballConfig;
import baseball.value.Code;
import baseball.utils.NumberUtils;

public class Computer {

    private int[] balls;

    public Computer() {
        balls = new int[BaseballConfig.BALL_COUNT];
    }

    public void generateBalls() {
        for (int i = 0; i < BaseballConfig.BALL_COUNT; i++) {
            int randomBall = (int) (Math.random() * BaseballConfig.END_BALL_NUM) + BaseballConfig.START_BALL_NUM;
            if (!hasBall(randomBall)) {
                balls[i] = randomBall;
            }
        }
    }

    public int[] getBalls() {
        return balls;
    }

    private boolean hasBall(int ball) {
        for (int i = 0; i < balls.length; i++) {
            if (balls[i] == ball) return true;
        }
        return false;
    }

}

