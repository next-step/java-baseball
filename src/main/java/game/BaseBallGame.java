package game;

import common.ConstantUtil;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BaseBallGame {
    private Referee referee;

    public Referee getReferee() {
        return referee;
    }

    public void startGame() {
        startGame(new Hitter());
    }

    private void startGame(Hitter hitter) {
        this.referee = new Referee();
        GameResult gameResult;

        do {
            gameResult = getReferee().getGameResult(new Pitcher(), hitter);
            gameResult.printGameResult();
        } while (!gameResult.isCorrect());

        reStartGame();
    }

    private void reStartGame() {
        if (isReStartGame(getInputThrowBalls())) {
            startGame();
        }
    }

    private String getInputThrowBalls() {
        String inputRestartGame = null;
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            inputRestartGame = scanner.next(ConstantUtil.INPUT_RESTART_PATTERN);
        } catch (InputMismatchException e) {
            System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
            scanner.nextLine();
            getInputThrowBalls();
        }

        return inputRestartGame;
    }

    private boolean isReStartGame(String input) {
        return input.equals("1");
    }
}
