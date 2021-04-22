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
            progress = inputGameOverNumber();
            initComputerNumber();
        }
    }

    private void progressGame() {
        boolean progress = true;
        while (progress) {
            user.selectNumber();
            judgeGame();
            printCurrentProgressMessage();
            progress = checkGameStop();
            initStrikeAndBall();
        }
    }

    private void judgeGame() {
        for (int i = 0; i < 3; i++) {
            checkStrike(i);
            checkBall(i);
        }
        ball = ball - strike;
    }

    private void checkStrike(int index) {
        int computerNumber = computer.getNumbers().get(index);
        int userNumber = user.getSelectNumbers().get(index);
        if (computerNumber == userNumber) {
            strike++;
        }
    }

    private void checkBall(int index) {
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

    private void printCurrentProgressMessage() {
        StringBuilder stringBuilder = new StringBuilder();
        if (strike > 0) {
            stringBuilder.append(strike).append(" 스트라이크 ");
        }
        if (ball > 0) {
            stringBuilder.append(ball).append("볼");
        }
        if (strike == 0 && ball == 0) {
            stringBuilder.append("낫싱");
        }
        System.out.println(stringBuilder);
    }

    private boolean checkGameStop() {
        if (strike == 3) {
            printGameStopMessage();
            return false;
        }
        return true;
    }

    private void printGameStopMessage() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료");
        System.out.println("게임을 새로 시작혀려면 1, 종료하려면 2를 입력하세요");
    }

    private boolean inputGameOverNumber() {
        Scanner scan = new Scanner(System.in);
        int input = scan.nextInt();
        return input == 1;
    }
}
