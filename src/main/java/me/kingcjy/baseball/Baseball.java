package me.kingcjy.baseball;

import me.kingcjy.baseball.ball.Ball;
import me.kingcjy.baseball.ball.BallCount;
import me.kingcjy.baseball.ball.BallGenerator;
import me.kingcjy.baseball.io.InputManager;

/**
 * @author KingCjy
 */
public class Baseball {
    public static final int DIGIT = 3;

    private static final String GAME_FINISH_MESSAGE = DIGIT + "개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private InputManager inputManager = new InputManager();

    public void start() {
        boolean restart = true;

        while (restart) {
            initGame();
            restart = inputManager.scanRestart();
        }
    }

    private void initGame() {
        BallGenerator generator = new BallGenerator();
        Ball computerBall = generator.generate(DIGIT);
        BallCount ballCount = new BallCount();

        while (!ballCount.isFinish()) {
            int[] numbers = inputManager.scanValidInput();
            Ball ball = new Ball(numbers);
            ballCount = computerBall.judgeBallCount(ball);
            System.out.println(ballCount.getMessage());
        }

        System.out.println(GAME_FINISH_MESSAGE);
    }
}
