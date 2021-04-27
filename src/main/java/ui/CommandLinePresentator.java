package ui;

import process.GameResult;

import java.util.Scanner;


public class CommandLinePresentator implements Presentator {
    private static final Scanner scanner = new Scanner(System.in);

    @Override
    public String presentInputNumber() {
        System.out.println("숫자를 입력해주세요:");
        return scanner.next();
    }

    @Override
    public void displayResult(GameResult gameResult) {
        if (gameResult.isNothing()) {
            System.out.println("낫싱");
            return;
        }
        displayStrikeAndBall(gameResult);
    }

    @Override
    public String endGame() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");
        return scanner.next();
    }

    @Override
    public void displayInputError() {
        System.out.println("잘못된 내용을 입력하였습니다. 다시 입력해주세요");
    }

    private void displayStrikeAndBall(GameResult gameResult) {
        if (gameResult.getStrike() > 0)
            System.out.print(gameResult.getStrike() + "스트라이크 ");
        if (gameResult.getBall() > 0)
            System.out.print(gameResult.getBall() + "볼");
        System.out.println();
    }
}
