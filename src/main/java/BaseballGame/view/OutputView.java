package BaseballGame.view;

import BaseballGame.domain.Inning;

public class OutputView {
    public static void printInningResult(Inning inning) {
        System.out.printf("%d볼%d스트라이크", inning.getBall(), inning.getStrike());
        printNewLine();
    }

    public static void printCorrectMessage() {
        System.out.println("정답입니다!");
    }

    public static void printNewLine() {
        System.out.println();
    }
}
