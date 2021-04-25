package com.woowahan.precourse.baseball.rule;

public class BaseBallRule {

    private BaseBallRule() {}

    public static boolean isStrike(String gameNumber, String inputNumber) {
        return gameNumber.equals(inputNumber);
    }

    public static boolean isBall(String gameNumber, String inputNumber) {
        return !gameNumber.equals(inputNumber);
    }

    public static boolean isVictory(int strikeCount) {
        return strikeCount == 3;
    }

    public static boolean isNothingAndFourBall(int strikeCount, int ballCount) {
        return strikeCount == 0 && ballCount == 0;
    }
}
