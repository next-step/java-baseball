package view;

import model.Player;

public class ResultView {

    private static final String STRIKE_FORMAT = "%s스트라이크";
    private static final String BALL_FORMAT = "%s볼 ";
    private static final String GAME_SET_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    public static void printResult(int strike, int ball) {
        printBalls(ball);
        printStrikes(strike);
        System.out.println();
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

    public static void printGameSet() {
        System.out.println(GAME_SET_MESSAGE);
    }
}
