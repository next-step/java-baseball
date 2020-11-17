package com.sang5c.baseball.ui;

import com.sang5c.baseball.domain.BaseballCount;

public class ResultView {

    private static final String BALL = " 볼 ";
    private static final String STRIKE = " 스트라이크 ";
    private static final String NOTHING = "낫싱";

    public static void printCount(BaseballCount baseballCount) {
        if (baseballCount.isNothing()) {
            System.out.println(NOTHING);
            return;
        }
        printStrikeCount(baseballCount);
        printBallCount(baseballCount);
        System.out.println();
    }

    private static void printBallCount(BaseballCount baseballCount) {
        if (baseballCount.getBallCount() != 0) {
            System.out.print(baseballCount.getBallCount() + BALL);
        }
    }

    private static void printStrikeCount(BaseballCount baseballCount) {
        if (baseballCount.getStrikeCount() != 0) {
            System.out.print(baseballCount.getStrikeCount() + STRIKE);
        }
    }

}
