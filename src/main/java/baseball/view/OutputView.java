package baseball.view;

import baseball.domain.score.Score;

public class OutputView {

    private OutputView() {
    }

    public static void printScore(Score score) {
        System.out.println(score.getResult());
    }
}
