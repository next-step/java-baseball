package baseball.model;

import baseball.config.BaseballConfig;
import baseball.utils.NumberUtils;
import baseball.value.Code;
import baseball.value.Result;

public class Computer {

    private int[] balls;

    public Computer() {
        balls = new int[BaseballConfig.BALL_COUNT];
    }

    public void generateBalls() {
        for (int i = 0; i < BaseballConfig.BALL_COUNT; i++) {
            int randomBall = (int) (Math.random() * BaseballConfig.END_BALL_NUM) + BaseballConfig.START_BALL_NUM;
            if (!NumberUtils.containsNumber(balls, randomBall)) {
                balls[i] = randomBall;
            }
        }
    }

    public int[] getBalls() {
        return balls;
    }

    private int checkBall(int playerBall, int ballIndex) {
        for (int i = 0; i < balls.length; i++) {
            if (balls[i] == playerBall && i == ballIndex) {
                return Code.STRIKE;
            }

            if (balls[i] == playerBall) {
                return Code.BALL;
            }
        }
        return Code.NOTHING;
    }

    public Result validate(int playerBalls) {
        Result result = new Result();
        int[] playerBallsArray = NumberUtils.splitToArray(playerBalls);

        for (int i = 0; i < playerBallsArray.length; i++) {
            result.setResultEntry(checkBall(playerBallsArray[i], i));
        }

        if (result.getStrike() == 0 && result.getBall() == 0) {
            result.setNothing();
        }

        return result;
    }
}

