package baseballgame.ui.output;

import baseballgame.dto.CompareResult;

import java.util.StringJoiner;

public class ConsoleOutput implements Output {
    private static final String SENTENCES_INPUT_USER_SCORE = "숫자를 입력해주세요: ";
    private static final String SENTENCES_FINISH_GAME = "3개의 숫자를 모두 맞히셨습니다! 게임종료";
    private static final String SENTENCES_RESTART_GAME = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요";
    private static final String STRIKE = "스트라이크";
    private static final String BALL = "볼";
    private static final int MISS_MATCH = 0;
    private static final String NOTHING = "Nothing";

    @Override
    public void demandingUserScore() {
        System.out.print(SENTENCES_INPUT_USER_SCORE);
    }

    @Override
    public void gameScore(final CompareResult result) {
        System.out.println(convertScorePrintTemplate(result));
    }

    private String convertScorePrintTemplate(final CompareResult result) {
        final int strikeCount = result.getStrikeCount();
        final int ballCount = result.getBallCount();

        if (validateMissMatching(strikeCount, ballCount)) {
            return NOTHING;
        }

        StringJoiner sj = new StringJoiner(" ");

        addStrike(strikeCount, sj);
        addBall(ballCount, sj);

        return sj.toString();
    }

    private boolean validateMissMatching(int strikeCount, int ballCount) {
        return (strikeCount == MISS_MATCH) && (ballCount == MISS_MATCH);
    }

    private void addStrike(final int strikeCount, final StringJoiner sj) {
        if (strikeCount == 0) {
            return;
        }

        sj.add(String.valueOf(strikeCount));
        sj.add(STRIKE);
    }

    private void addBall(final int ballCount, final StringJoiner sj) {
        if (ballCount == 0) {
            return;
        }

        sj.add(String.valueOf(ballCount));
        sj.add(BALL);
    }

    @Override
    public void gameFinish() {
        System.out.println(SENTENCES_FINISH_GAME);
    }

    @Override
    public void demandingWhetherWantToRestartGame() {
        System.out.println(SENTENCES_RESTART_GAME);
    }
}
