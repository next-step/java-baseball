package view;

import model.Player;

public class ResultView {

    private static final String STRIKE_FORMAT = "%s스트라이크\n";
    private static final String BALL_FORMAT = "%s볼 ";

    public static void printResult(int strike, int ball) {
        printStrikes(strike);
        printBalls(ball);
    }

    private static void printBalls(int ball) {
        if (ball > 0) {
            System.out.printf(BALL_FORMAT,ball);
        }

    }

    private static void printStrikes(int strike) {
        if (strike > 0) {
            System.out.printf(STRIKE_FORMAT,strike);
        }
    }
}
