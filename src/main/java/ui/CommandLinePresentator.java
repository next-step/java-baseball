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

    private void displayStrikeAndBall(GameResult gameResult) {
        if (gameResult.getStrike() > 0)
            System.out.print(gameResult.getStrike() + "스트라이크 ");
        if (gameResult.getBall() > 0)
            System.out.print(gameResult.getBall() + "볼");
        System.out.println();
    }
}
