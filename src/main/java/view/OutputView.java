package view;

import domain.Result;
import domain.Score;

import static java.lang.System.lineSeparator;

public class OutputView {

    public static void showResult(Result result) {
        int strikeCount = result.getStrikeCount();
        int ballCount = result.getBallCount();
        displayStrike(strikeCount);
        displayBall(ballCount);
        displayNothing(result);
        System.out.print(lineSeparator());
    }

    private static void displayStrike(int strikeCount) {
        if (strikeCount > 0) {
            System.out.print(String.format(Score.STRIKE.getScoreMessage(), strikeCount));
        }
    }

    private static void displayBall(int ballCount) {
        if (ballCount > 0) {
            System.out.print(String.format(Score.BALL.getScoreMessage(), ballCount));
        }
    }

    private static void displayNothing(Result result) {
        if (result.isNothing()) {
            System.out.print(Score.NOTHING.getScoreMessage());
        }
    }
}
