package baseballgame;

import java.util.Scanner;

public class Game {
    private final Computer computer;
    private final User user;
    private int strike;
    private int ball;

    public Game() {
        this.computer = new Computer();
        this.user = new User();
    }

    public void startGame() {
        boolean progress = true;
        while (progress) {
            computer.selectNumber();
            progressGame();
            progress = isGameStop();
            initComputerNumber();
        }
    }

    private void progressGame() {
        boolean progress = true;
        while (progress) {
            user.selectNumber();
            judgeGame();
            printStrike();
            printBall();
            printNothing();
            progress = isGameOver();
            initStrikeAndBall();
        }
    }

    private void judgeGame() {
        for (int i = 0; i < Const.NUMBER_COUNT; i++) {
            increaseStrike(i);
            increaseBall(i);
        }
        ball = ball - strike;
    }

    private void increaseStrike(int index) {
        int computerNumber = computer.getNumbers().get(index);
        int userNumber = user.getSelectNumbers().get(index);
        if (computerNumber == userNumber) {
            strike++;
        }
    }

    private void increaseBall(int index) {
        if (computer.getNumbers().contains(user.getSelectNumbers().get(index))) {
            ball++;
        }
    }

    private void initStrikeAndBall() {
        this.strike = 0;
        this.ball = 0;
    }

    private void initComputerNumber() {
        computer.selectNumber();
    }

    private void printStrike() {
        if (strike > 0) {
            printMessage(strike + GameMessageEnum.STRIKE.getMessage());
        }
    }

    private void printBall() {
        if (ball > 0) {
            printMessage(ball + GameMessageEnum.BALL.getMessage());
        }
    }

    private void printNothing() {
        if (strike == 0 && ball == 0) {
            printMessage(GameMessageEnum.NOTHING.getMessage());
        }
    }

    private void printGameOverMessage() {
        printMessage(GameMessageEnum.GAME_OVER.getMessage());
        printMessage(GameMessageEnum.NEW_GAME.getMessage());
    }

    private boolean isGameOver() {
        if (strike == Const.NUMBER_COUNT) {
            printGameOverMessage();
            return false;
        }
        return true;
    }

    private boolean isGameStop() {
        int input = inputGameStopNumber();
        return input == Const.GAME_STOP_VALUE;
    }

    private int inputGameStopNumber() {
        Scanner scan = new Scanner(System.in);
        return scan.nextInt();
    }

    private void printMessage(String message) {
        System.out.println(message);
    }
}