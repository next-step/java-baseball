package com.woowahan.precourse.baseball.rule;

public class BaseBallRule {

    public static boolean isStrike(String gameNumber, String inputNumber) {
        return gameNumber.equals(inputNumber);
    }

    public static boolean isBall(String gameNumber, String inputNumber) {
        return !gameNumber.equals(inputNumber);
    }
}
