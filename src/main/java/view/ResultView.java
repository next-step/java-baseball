package view;

import domain.Score;

public class ResultView {
    public void printScore(Score score) {
        System.out.println(scoreToString(score));
    }

    public void printFinish() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    private String scoreToString(Score score) {
        StringBuilder builder = new StringBuilder();

        strikeToString(builder, score.strike());
        ballToString(builder, score.ball());

        if (builder.length() == 0) {
            builder.append("낫싱");
        }
        return builder.toString();
    }

    private void strikeToString(StringBuilder builder, int strike) {
        if (strike > 0) {
            builder.append(String.format("%d 스트라이크 ", strike));
        }
    }

    private void ballToString(StringBuilder builder, int ball) {
        if (ball > 0) {
            builder.append(String.format("%d 볼", ball));
        }
    }
}
