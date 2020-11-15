package baseballgame.ui.output;

import baseballgame.dto.CompareResult;

import java.util.StringJoiner;

public class ConsoleOutput implements Output {
    private static final String SENTENCES_INPUT_USER_SCORE = "숫자를 입력해주세요: ";
    private static final String STRIKE = "스트라이크";
    private static final String BALL = "볼";

    @Override
    public void demandingUserScore() {
        System.out.print(SENTENCES_INPUT_USER_SCORE);
    }

    @Override
    public void gameScore(final CompareResult result) {
        System.out.println(convertScorePrintTemplate(result));
    }

    private String convertScorePrintTemplate(final CompareResult result) {
        StringJoiner sj = new StringJoiner(" ");
        addStrike(result, sj);
        addBall(result, sj);

        return sj.toString();
    }

    private void addStrike(final CompareResult result, final StringJoiner sj) {
        final int strikeCount = result.getStrikeCount();
        if (strikeCount == 0) {
            return;
        }

        sj.add(String.valueOf(strikeCount));
        sj.add(STRIKE);
    }

    private void addBall(final CompareResult result, final StringJoiner sj) {
        final int ballCount = result.getBallCount();

        if (ballCount == 0) {
            return;
        }

        sj.add(String.valueOf(ballCount));
        sj.add(BALL);
    }
}
