package com.github.sangholeedev.javabaseball;

import java.util.List;
import java.util.Scanner;

public class JavaBaseballGame {
    private Scanner scanner;
    private Opponent opponent;
    private int strikeCount;
    private int ballCount;

    private JavaBaseballGame() {
        scanner = new Scanner(System.in);
        opponent = Opponent.getInstance();
        initCount();
    }

    private static class JavaBaseballGameInstanceClazz {
        private static final JavaBaseballGame instance = new JavaBaseballGame();
    }

    public static JavaBaseballGame getInstance() {
        return JavaBaseballGameInstanceClazz.instance;
    }

    public void playGame() {
        while (isWrongAnswer()) {
            startMatch();
        }
        endMatch();
    }

    private void startMatch() {
        initCount();
        int userInputValue = getUserInput();

        if (isaBadInput(userInputValue)) {
            startMatch();
            return;
        }

        List<BallDecision> ballDecisions = Umpire.validBaseball(opponent.getBaseballNumber(), userInputValue);
        ballDecisionCount(ballDecisions);
        printBallDecision();
    }

    private boolean isaBadInput(int userInputValue) {
        return userInputValue == -1;
    }

    private int getUserInput() {
        printUserInputMessage();
        String input = scanner.next();
        int intValue;
        intValue = validParseNumber(input);
        intValue = valid3Number(intValue);

        return intValue;
    }

    private int valid3Number(int intValue) {
        if ((int) (Math.log10(intValue)) != 2) {
            System.out.println("에러 : 3자리수 숫자를 입력해주세요.");
            return -1;
        }
        return intValue;
    }

    private int validParseNumber(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println("에러 : 숫자로 입력해주세요.");
            return -1;
        }
    }

    private void printUserInputMessage() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    private void initCount() {
        strikeCount = 0;
        ballCount = 0;
    }

    private boolean isWrongAnswer() {
        return strikeCount < 3;
    }

    private void ballDecisionCount(List<BallDecision> ballDecisions) {
        for (BallDecision ballDecision : ballDecisions) {
            increaseStrikeCount(ballDecision);
            increaseBallCount(ballDecision);
        }
    }

    private void increaseStrikeCount(BallDecision ballDecision) {
        if (ballDecision == BallDecision.STRIKE) {
            ++strikeCount;
        }
    }

    private void increaseBallCount(BallDecision ballDecision) {
        if (ballDecision == BallDecision.BALL) {
            ++ballCount;
        }
    }

    private void printNotThing() {
        System.out.print(BallDecision.NOT_THING.getPrintName());
    }

    private void printStrike() {
        System.out.print(strikeCount + BallDecision.STRIKE.getPrintName());
    }

    private void printBall() {
        System.out.print(ballCount + BallDecision.BALL.getPrintName());
    }

    private void printBallDecision() {
        if (ballCount == 0 && strikeCount == 0) {
            printNotThing();
        }
        if (strikeCount != 0) {
            printStrike();
            System.out.print(" ");
        }
        if (ballCount != 0) {
            printBall();
        }
        System.out.println();
    }

    private void endMatch() {
        printRestartGameMessage();

        int userChoice = scanner.nextInt();
        if (userChoice == 2) {
            scanner.close();
            return;
        }

        if (userChoice == 1) {
            initCount();
            opponent.generate3Number();
            playGame();
            return;
        }
        endMatch();
    }

    private void printRestartGameMessage() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

}






