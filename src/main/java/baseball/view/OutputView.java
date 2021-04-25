package baseball.view;

import baseball.domain.Record;
import baseball.domain.Result;

import static java.lang.System.lineSeparator;

public class OutputView {

    private static OutputView outputView;

    private OutputView() {
    }

    public static OutputView getInstance() {
        if (outputView == null) {
            outputView = new OutputView();
        }
        return outputView;
    }

    public void drawResult(Result result) {
        int strikeCount = result.countStrike();
        int ballCount = result.countBall();
        displayStrike(strikeCount);
        displayBall(ballCount);
        displayNothing(result);
        System.out.print(lineSeparator());
    }

    private static void displayStrike(int strikeCount) {
        if (strikeCount > 0) {
            System.out.print(String.format(Record.STRIKE.getRecordMessage(), strikeCount));
        }
    }

    private static void displayBall(int ballCount) {
        if (ballCount > 0) {
            System.out.print(String.format(Record.BALL.getRecordMessage(), ballCount));
        }
    }

    private static void displayNothing(Result result) {
        if (result.isNothing()) {
            System.out.print(Record.NOTHING.getRecordMessage());
        }
    }
}
