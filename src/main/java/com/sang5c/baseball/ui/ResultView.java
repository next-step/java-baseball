package com.sang5c.baseball.ui;

import com.sang5c.baseball.domain.Count;

public class ResultView {

    public static void printCount(Count count) {
        if (count.isNothing()) {
            System.out.println("낫싱");
            return;
        }
        printStrikeCount(count);
        printBallCount(count);
        System.out.println();
    }

    private static void printBallCount(Count count) {
        if (count.getBallCount() != 0) {
            System.out.print(count.getBallCount() + "볼");
        }
    }

    private static void printStrikeCount(Count count) {
        if (count.getStrikeCount() != 0) {
            System.out.print(count.getStrikeCount() + " 스트라이크 ");
        }
    }

}
