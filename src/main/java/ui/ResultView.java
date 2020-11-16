package ui;

import domain.ResultGame;
import domain.Score;

public class ResultView {
    private static final int GO_BUTTON = 1;
    private static final int STOP_BUTTON = 2;

    public static void printScore(final ResultGame resultGame) {
        StringBuilder stringBuilder = new StringBuilder();
        if (resultGame.isNothing()) {
            stringBuilder.append("낫싱");
        }

        appendScore(resultGame.count(Score.STRIKE), " 스트라이크 ", stringBuilder);
        appendScore(resultGame.count(Score.BALL), " 볼 ", stringBuilder);
        System.out.println(stringBuilder.toString());
    }

    public static void endMessage() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 " + GO_BUTTON + ", 종료하려면 " + STOP_BUTTON + "를 입력하세요.");
    }

    private static void appendScore(final int score, final String message, final StringBuilder stringBuilder) {
        if (score != 0) {
            stringBuilder.append(score);
            stringBuilder.append(message);
        }
    }
}
