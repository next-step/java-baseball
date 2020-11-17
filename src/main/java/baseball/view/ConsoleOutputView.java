package baseball.view;

import java.io.PrintStream;

public class ConsoleOutputView {

    private static final String WINNING_BASEBALL = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String RESULT_STRIKE = "%d스트라이크 ";
    private static final String RESULT_BALL = "%d볼 ";

    private static final PrintStream CONSOLE = System.out;

    private ConsoleOutputView() { }

    public static void printEndGame() {
        ConsoleOutputView.print(WINNING_BASEBALL);
    }

    public static void printGameResult(int strikeCount, int ballCount) {
        if(strikeCount != 0) {
            ConsoleOutputView.print(String.format(RESULT_STRIKE, strikeCount));
        }

        if(ballCount != 0) {
            ConsoleOutputView.print(String.format(RESULT_BALL, ballCount));
        }

        newline();
    }

    public static void print(final Object message) {
        CONSOLE.print(message);
    }

    public static void newline() {
        CONSOLE.println();
    }
}
