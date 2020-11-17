package edu.example.numberbaseball.console;

import static java.lang.System.out;

public class OutputConsole {
    private static final String STRIKE = "스트라이크";
    private static final String BALL = "볼";
    private static final String WINNING_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String NOTHING_MESSAGE = "낫싱";

    private OutputConsole() {
    }

    public static void printStrikeAndBall(int strikeNumber, int ballNumber) {
        if (strikeNumber == 0 && ballNumber == 0) {
            printNothingMessage();
            return;
        }
        printStrike(strikeNumber);
        printBall(ballNumber);
        out.println();
    }

    public static void printWinningMessage() {
        out.println(WINNING_MESSAGE);
    }

    private static void printStrike(int strikeNumber) {
        if (strikeNumber != 0) {
            out.print(strikeNumber + " " + STRIKE + " ");
        }
    }

    private static void printBall(int ballNumber) {
        if (ballNumber != 0) {
            out.print(ballNumber + BALL + " ");
        }
    }

    private static void printNothingMessage() {
        out.println(NOTHING_MESSAGE);
    }
}
