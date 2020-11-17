package me.kingcjy.baseball;

/**
 * @author KingCjy
 */
public class Baseball {
    public static final int DIGIT = 3;

    private static final String GAME_FINISH_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    public void start() {
        while (true) {
            initGame();
        }
    }

    private void initGame() {
        InputManager inputManager = new InputManager();
        BallGenerator generator = new BallGenerator();
        Ball computerBall = generator.generate(DIGIT);
        BallCount ballCount = new BallCount();

        while (!ballCount.isFinish()) {
            int[] numbers = inputManager.scanValidInput();
            Ball ball = new Ball(numbers);
            ballCount = computerBall.judgeBallCount(ball);
            ballCount.printResult();
        }

        System.out.println(GAME_FINISH_MESSAGE);
    }
}
