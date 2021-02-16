package BaseballGame.view;

import BaseballGame.domain.Inning;

public class OutputView {
    public static void printInningResult(Inning inning) {
        System.out.printf("%d볼%d스트라이크", inning.getBall(), inning.getStrike());
    }
}
