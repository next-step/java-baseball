package ui;

import domain.Score;

public class ResultView {
    private static final int GO_BUTTON = 1;
    private static final int STOP_BUTTON = 2;

    public static void printScore(Score score) {
        StringBuilder stringBuilder = new StringBuilder();
        if (score.isNothing()) {
            stringBuilder.append("낫싱");
        }
        appendScore(score.getStrike(), " 스트라이크 ", stringBuilder);
        appendScore(score.getBall(), " 볼 ", stringBuilder);
        System.out.println(stringBuilder.toString());
    }

    public static void endMessage() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 " + GO_BUTTON + ", 종료하려면 " + STOP_BUTTON + "를 입력하세요.");
    }

    private static void appendScore(int score, String message, StringBuilder stringBuilder) {
        if (score != 0) {
            stringBuilder.append(score);
            stringBuilder.append(message);
        }
    }
}
