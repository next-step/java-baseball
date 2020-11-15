package baseball.view;

import baseball.domain.MatchResult;

public class OutputView {

    private static final String COMPLETION_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임종료\n" +
            "게임을 새로 시작하려면 1, 종료 하려면 2를 입력하세요.";
    private static final int VIEW_COUNT = 0;
    private static final String STRIKE_MESSAGE = "%d 스트라이크 ";
    private static final String BALL_MESSAGE = "%d 볼";
    private static final String NOTHING_MESSAGE = "낫싱";

    public static void showCompletionMessage() {
        System.out.println(COMPLETION_MESSAGE);
    }

    public static void showMatchResult(final MatchResult result) {
        int strikeCount = result.getStrikeCount();
        int ballCount = result.getBallCount();

        if (strikeCount > VIEW_COUNT) {
            System.out.print(String.format(STRIKE_MESSAGE, strikeCount));
        }

        if (ballCount > VIEW_COUNT) {
            System.out.print(String.format(BALL_MESSAGE, ballCount));
        }

        if (strikeCount == VIEW_COUNT && ballCount == VIEW_COUNT) {
            System.out.print(NOTHING_MESSAGE);
        }

        System.out.println();
    }

}
