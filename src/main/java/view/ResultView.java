package view;

import domain.Score;

public class ResultView {
    public void printScore(Score score) {
        System.out.println(scroeToString(score));
    }

    private String scroeToString(Score score) {
        StringBuilder builder = new StringBuilder();

        if (score.strike() > 0) {
            builder.append(String.format("%d 스트라이크 ", score.strike()));
        }

        if (score.ball() > 0) {
            builder.append(String.format("%d 볼", score.ball()));
        }

        if (builder.length() == 0) {
            builder.append("낫싱");
        }

        return builder.toString();
    }
}
