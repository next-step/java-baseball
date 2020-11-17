package com.sang5c.baseball.ui;

import com.sang5c.baseball.domain.Count;

public class ResultView {

    private static final String BALL = " 볼 ";
    private static final String STRIKE = " 스트라이크 ";
    private static final String NOTHING = "낫싱";

    public static void printCount(Count count) {
        if (count.isNothing()) {
            System.out.println(NOTHING);
            return;
        }
        printStrikeCount(count);
        printBallCount(count);
        System.out.println();
    }

    private static void printBallCount(Count count) {
        if (count.getBallCount() != 0) {
            System.out.print(count.getBallCount() + BALL);
        }
    }

    private static void printStrikeCount(Count count) {
        if (count.getStrikeCount() != 0) {
            System.out.print(count.getStrikeCount() + STRIKE);
        }
    }

}
