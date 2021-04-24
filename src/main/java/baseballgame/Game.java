package baseballgame;

import java.util.Scanner;

public class Game {
    Computer computer;
    User user;
    int strike;
    int ball;

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
        for (int i = 0; i < 3; i++) {
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
            System.out.println(strike + " 스트라이크 ");
        }
    }

    private void printBall() {
        if (ball > 0) {
            System.out.println(ball + "볼");
        }
    }

    private void printNothing() {
        if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
        }
    }

    private void printGameOverMessage() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료");
        System.out.println("게임을 새로 시작혀려면 1, 종료하려면 2를 입력하세요");
    }

    private boolean isGameOver() {
        if (strike == 3) {
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
}
