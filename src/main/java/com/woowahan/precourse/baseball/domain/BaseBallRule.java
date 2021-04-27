package com.woowahan.precourse.baseball.domain;

public class BaseBallRule {

    private BaseBallRule() {}


    public static boolean isVictory(int strikeCount) {
        return strikeCount == 3;
    }

    public static boolean isNothingAndFourBall(int strikeCount, int ballCount) {
        return strikeCount == 0 && ballCount == 0;
    }
}
